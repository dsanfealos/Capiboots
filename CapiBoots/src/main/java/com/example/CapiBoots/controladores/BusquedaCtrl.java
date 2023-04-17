package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusquedaCtrl {

    @GetMapping("/busqueda")
    public String busqueda(Model modelo){

        return "busqueda";
    }
}
