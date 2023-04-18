package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import java.util.Optional;

@Controller
//@RequestMapping("/version1")
public class UsuarioCtrl {

//    @Autowired
//    private UsuarioSrvc ususrvc;

    @GetMapping("")
    public String inicio(Model modelo) {
        modelo.addAttribute("titulo", "Página de inicio de relaciones N:M");
        return "index";
    }

    @GetMapping("/acceso")
    public String Acceso(Model modelo) {
        modelo.addAttribute("titulo", "Página de acceso");
        return "login";
    }

    @PostMapping("/acceso")
    public String comprobarAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
        String texto = "Hola " + usu + " tu clave es " + clave + ".";
        modelo.addAttribute("texto", texto);

        return"exitoLogin";
    }

//    @PostMapping("/acceso")
//    public String PostAcceso(Model modelo, @RequestParam("usuario") String usu, @RequestParam("clave") String clave){
//        Optional<Usuario> usuario;
//        ususrvc.buscan(usu);
//        if (usuario !== null){
//            return "siquiente pantalla";
//        }
//        if (usuario.get().getClave() == clave){
//
//        }
//        // Verificar que el usuario existe y entrega lña clave correcta
//        modelo.addAttribute("titulo", "Acceso exitoso");
//        return "accedido";
//    }

    @GetMapping("/registro")
    public String Registro(Model modelo){
        modelo.addAttribute("titulo", "CapiBoots");
        modelo.addAttribute("titulo2", "Esta es mi aplicación CapiBoots");
        return "registro";
    }

    @PostMapping("/registro")
    public String alta(Model modelo){
        return "exito";
    }

    @GetMapping("/suscripcion")
    public String Suscripcion (Model modelo) {
        // Buscar el registro en la BBDD
        // colocar los datos en el parámetro que pasas a la vista de Thymeleaf
        modelo.addAttribute("titulo", "Estás viendo tus datos de suscripción");
        // devuelve el archivo html con la vista
        return "suscripcion";
    }

    @GetMapping("/listamigos")
    public String ListaAmigos (Model modelo) {
        return "listaAmigos";
    }

}
