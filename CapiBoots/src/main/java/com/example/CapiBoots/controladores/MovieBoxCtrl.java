package com.example.CapiBoots.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieBoxCtrl {

    @GetMapping("/moviebox")
    public String moviebox(Model modelo){

        modelo.addAttribute("titulo","Moviebox");
        return "moviebox";
    }
    @GetMapping("/bookbox")
    public String bookbox(Model modelo){

        modelo.addAttribute("titulo","BookBox");
        return "bookbox";
    }
    @GetMapping("/showboox")
    public String showbox(Model modelo){

        modelo.addAttribute("titulo","Showbox");
        return "showbox";
    }
    @GetMapping("/favoritos")
    public String favoritos(Model modelo){

        modelo.addAttribute("titulo","Favoritos");
        return "favoritos";
    }

}
