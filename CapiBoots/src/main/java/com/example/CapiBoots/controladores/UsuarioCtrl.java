package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioCtrl {
    @GetMapping("")
    public String inicio(Model modelo) {
        modelo.addAttribute("titulo", "Página de inicio de relaciones N:M");
        return "index";
    }

    @GetMapping("/acceso")
    public String acceso(Model modelo) {
        modelo.addAttribute("titulo", "Página de acceso");
        return "login";
    }

    @PostMapping("/acceso")
    public String postAcceso(Model modelo){
        // Verificar que el usuario existe y entrega lña clave correcta
        modelo.addAttribute("titulo", "Acceso exitoso");
        return "accedido";
    }

    @GetMapping("/registro")
    public String registro(Model modelo){

        modelo.addAttribute("titulo", "Acceso exitoso");
        return "registro";
    }

}
