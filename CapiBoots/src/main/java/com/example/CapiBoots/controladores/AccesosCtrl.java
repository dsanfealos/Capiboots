package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.AccesosRepositorio;
import com.example.CapiBoots.servicios.AccesosSrvcImpls;
import com.example.CapiBoots.servicios.ContenidosSrvcImpls;
import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.swing.*;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

@Controller
public class AccesosCtrl {
    @Autowired
    public AccesosSrvcImpls accessSrvc;
    @Autowired
    public UsuarioSrvcImpls usuSrvc;

    @Autowired
    public ContenidosSrvcImpls contSrvc;

    //Lista
    @GetMapping("/lista-pendientes")
    public String listaPdtes(Principal principal, Model modelo) {
        String usuID = principal.getName();
        Usuario user = usuSrvc.buscaPorNombre(usuID);
        Long id = user.getId();
        //Usando la ID del usuario, buscamos sus pendientes
        modelo.addAttribute("pendientes", accessSrvc.buscaPendientes(id));
        modelo.addAttribute("titulo", "Seguir Viendo");
        return "/listas/lista-pendientes";
    }

    //Interuptores "empezar" y "terminar" para pendientes
    @GetMapping("/empezar/{id}")
//    @ResponseStatus(value = HttpStatus.OK)  // indica que la respuesta tendrá un status OK y no hay que devolver nada
    public String empezar(@PathVariable Long id, Principal principal, Model modelo) {
        String nombre = principal.getName();
        Usuario usu = usuSrvc.buscaPorNombre(nombre);
        Optional<Contenidos> contOpt = contSrvc.buscarContenidoId(id);
        Contenidos cont = contOpt.get();

        // buscar el último acceso del usuario al contenido (usu_id, cont_id)
        Optional<Accesos> ultAccesoOpt = accessSrvc.buscaUltimoAcceso(usu.getId(), id);

        // Si no hay ninguno, es la primera vez que el usuario empieza el contenido y hay que marcarlo. Para ello,
        // añadimos un nuevo registro a la tabla de accesos
        if (ultAccesoOpt != null) {
            // Ya existe un acceso previo de ese usuario a ese contenido, y terminado = true.
            // Se vuelve a poner terminado = false
            if (ultAccesoOpt.get().getTerminado()) {
                ultAccesoOpt.get().setTerminado(Boolean.FALSE);
                ultAccesoOpt.get().setFecha_fin(null);
                accessSrvc.guardar(ultAccesoOpt.get());
            }
        } else {
            // No existe acceso previo. Se crea un nuevo registro.
            Accesos nuevoAcceso = new Accesos();
            Date ahora = new Date(System.currentTimeMillis());
            nuevoAcceso.setFecha_inicio(ahora);
            nuevoAcceso.setUsuario(usu);
            nuevoAcceso.setContenido(cont);
            nuevoAcceso.setTerminado(Boolean.FALSE);
            accessSrvc.guardar(nuevoAcceso);
        }
        return "redirect:/reproducir/{id}";
    }

    @GetMapping("/terminar/{id}")
    public String terminar(@PathVariable Long id, Principal ppal, Model modelo) {

        // localizamos el usuario
        String nombre = ppal.getName();
        Usuario usu = usuSrvc.buscaPorNombre(nombre);

        // buscar el último acceso del usuario al contenido
        Optional<Accesos> ultAccesoOpt = accessSrvc.buscaUltimoAcceso(usu.getId(), id);

        if (ultAccesoOpt != null) {
            // Ya existe un acceso previo de ese usuario a ese contenido, y terminado = true.
            // Se vuelve a poner terminado = false
            ultAccesoOpt.get().setFecha_fin(LocalDateTime.now());
            ultAccesoOpt.get().setTerminado(Boolean.TRUE);
            accessSrvc.guardar(ultAccesoOpt.get());
        }
        return "redirect:/reproducir/{id}";
    }
}