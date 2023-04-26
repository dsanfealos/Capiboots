package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Logro;
import com.example.CapiBoots.servicios.LogroSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class LogroCtrl {


        @Autowired
        private LogroSrvcImpls logroSrvc;

        @GetMapping("/logro")
        public String Logro(Model modelo) {
            modelo.addAttribute("titulo", "Logros");
            return "Logro";
        }


    //Lista de Usuarios
    @GetMapping("/logro/lista-logro")
    public String listaLogro(Model modelo) {
        modelo.addAttribute("listaLogro", logroSrvc.listaLogro());
        return "/listas/lista-logro";
    }

    //Crear logro, guardar, borrar y editar
    @GetMapping("/logro/nuevo-logro")
    public String crearLogro(Model modelo) {
        modelo.addAttribute("logro", new Logro());
        return "/forms/nuevo-logro";
    }

    @PostMapping("/logro/guardar")
    public String guardarLogro(Logro logros) {
        logroSrvc.guardar(logros);
        return "redirect:/logro/lista-logro";
    }

    @GetMapping("/logro/borrar/{id}")
    public String borrarLogro(@PathVariable Long id) {
        logroSrvc.borrar(id);
        return "redirect:/logro/lista-logro";
    }

    @GetMapping("/logro/editar/{id}")
    public String editarLogro(@PathVariable Long id, Model modelo){
        Optional<Logro> LogroOptional = logroSrvc.buscarLogroId(id);
        if (LogroOptional.isPresent()) {
            modelo.addAttribute("logro", LogroOptional.get());
        }else{
            return "error";
        }
            return "forms/nuevo-logro";
}



}
