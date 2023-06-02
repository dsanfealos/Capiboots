package com.example.CapiBoots.controladores.registro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCtrl {

    //Cargamos la vista de login
    @GetMapping("/login")
    public String login() {
        return "/administrarUsuario/login";
    }

    //Volvemos "loginError" true cuando no se cumplen los campos requeridos
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/administrarUsuario/login";
    }

    //Logout
    @GetMapping("/login?logout")
    public String logout(){

        return "/administrarUsuario/login";
    }
}
