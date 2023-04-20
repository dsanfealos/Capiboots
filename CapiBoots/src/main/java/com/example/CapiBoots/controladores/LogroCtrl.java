package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.LogroSrvcImpls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class LogroCtrl {

    @Controller
    public class logroCtrl {
        private LogroSrvcImpls logroSrvc;
        @GetMapping("/logros")
        public String Logro(Model modelo) {
            modelo.addAttribute("titulo", "Logros");
            return "Logros";
        }
    }
    }