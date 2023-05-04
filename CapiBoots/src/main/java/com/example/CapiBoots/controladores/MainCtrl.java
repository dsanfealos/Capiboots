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
//        List<Contenidos> pdtes = accessSrvc.buscaPendientes(2L);
//        modelo.addAttribute("pendientes", pdtes);
        modelo.addAttribute("titulo", "Página de inicio de relaciones N:M");
        return "/inicio";
    }

    @GetMapping("/home")
    public String Home(Model modelo) {
        modelo.addAttribute("titulo", "Home");
        return "/home";
    }

}
