package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

@Controller
//@RequestMapping("/version1")
public class UsuarioCtrl {
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
    public String PostAcceso(Model modelo){
        // Verificar que el usuario existe y entrega lña clave correcta
        modelo.addAttribute("titulo", "Acceso exitoso");
        return "accedido";
    }

    @GetMapping("/registro")
    public String Registro(Model modelo){
        modelo.addAttribute("titulo", "CapiBoots");
        modelo.addAttribute("titulo2", "Esta es mi aplicación CapiBoots");
        return "registro";
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
