package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LogroCtrl {

    @Controller
    public class logroCtrl {
        @GetMapping("/logros")
        public String Logro(Model modelo) {
            modelo.addAttribute("titulo", "Logros");
            return "Logros";
        }
    }
    }