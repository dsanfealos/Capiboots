package com.example.CapiBoots.controladores.registro;

import com.example.CapiBoots.dto.UsuarioDto;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.servicios.UsuarioSrvcImpls;
import com.example.CapiBoots.servicios.ifxUsuarioSrvc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroCtrl {

    @Autowired
    private UsuarioSrvcImpls usuSrvc;

    // Llamamos a la pantalla de registro
    @GetMapping(value={"/register","/signup"})
    public String showRegistrationForm(Model model){
        // Creamos Usuario con su etiqueta
        UsuarioDto usu = new UsuarioDto();
        model.addAttribute("user", usu);
        return "/administrarUsuario/registro";
    }


// Guardamos el usuario con el form del html de registro
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UsuarioDto userDto, BindingResult result,
                               Model model){
        //Busca si existe un usuario con el mismo nombre que hemos introducido
        Usuario existingUser = usuSrvc.buscaPorCorreo(userDto.getCorreo());

        //Si existe un usuario con el mismo nombre, salta un aviso
        if(existingUser != null && existingUser.getCorreo() != null && !existingUser.getCorreo().isEmpty()){
            result.rejectValue("correo", null,
                    "Ya existe un usuario con ese email");
        }

        //Si hay algún error, recargamos la página de registro y declaramos otro userDto
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/administrarUsuario/registro";
        }

        //Guardamos el usuario si se han cumplido las condiciones
        usuSrvc.guardar(userDto);
        return "redirect:/register?success";
    }

}
