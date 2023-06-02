package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {


    @GetMapping({"","/inicio"})
    public String inicio(Model modelo) {
        modelo.addAttribute("titulo", "Bienvenid@ a CapiBoots");
        return "/inicio";
    }

    @GetMapping("/home")
    public String Home(Model modelo) {
        modelo.addAttribute("titulo", "Home");
        return "/home";
    }
}
