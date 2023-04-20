package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.MedioSrvcImpls;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class MedioCtrl {

    @Controller
public class medioCtrl {
        private MedioSrvcImpls medioSrvc;
    @GetMapping("/medios")
    public String Medio(Model modelo) {
        modelo.addAttribute("titulo", "Medios");
        return "Medios";
    }
    @GetMapping("/guardarDatos")
        public String guardarDatos(Model modelo) {
            modelo.addAttribute("guardarDatos", medioSrvc.guardarDatos());
            return "guardarDatos";
        }
    @GetMapping("/eliminarDatos")
        public String eliminarDatos(Model modelo) {
            modelo.addAttribute("eliminarDatos", medioSrvc.eliminarDatos());
            return "eliminarDatos";
        }
    @GetMapping("/listaMedio")
        public String listaMedio(Model modelo) {
            modelo.addAttribute("listaMedio", medioSrvc.listaMedio());
            return "listaMedio";
        }
}
}
