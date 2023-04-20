package com.example.CapiBoots.controladores;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class MedioCtrl {

    @Controller
public class medioCtrl {
    @GetMapping("/medios")
    public String Medio(Model modelo) {
        modelo.addAttribute("titulo", "Medios");
        return "Medios";
    }
}
}
