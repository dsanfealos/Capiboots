package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.servicios.AccesosSrvcImpls;
import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainCtrl {

    @Autowired
    private AccesosSrvcImpls accessSrvc;
    @Autowired
    private UsuarioSrvcImpls usuSrvc;


    //Validación cuando se ha hecho login
    @GetMapping({"","/","/inicio","/home"})
    String index(Principal principal, Model modelo) {
        if (principal != null){
            //De esta forma, obtenemos el usuario en cuestión que está viendo Moviebox
            String usuID = principal.getName();
            Usuario user =  usuSrvc.buscaPorNombre(usuID);
            Long id = user.getId();
            //Usando la ID del usuario, buscamos sus pendientes
            modelo.addAttribute("pendientes",accessSrvc.buscaPendientes(id));
            modelo.addAttribute("titulo", "Home");
        }
        return principal != null ? "home" : "inicio";
    }
}
