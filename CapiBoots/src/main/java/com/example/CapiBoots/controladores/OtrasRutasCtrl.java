package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtrasRutasCtrl {
    @GetMapping({"","/","/inicio","/index"})
    public String Inicio () {
        return "inicio";
    }

    @GetMapping("/hazalgo")
    public String HazAlgo(){
        return "indeeeeex";
    }
}
