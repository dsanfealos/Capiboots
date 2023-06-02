package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Temporada;
import com.example.CapiBoots.servicios.TemporadaSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TemporadaCtrl {

    @Autowired
    public TemporadaSrvcImpls tempoSrvc;

    //Listas de Temporadas de cada serie
    @GetMapping("/lista-temporadas")
    public String listaSeries (Model modelo){
        modelo.addAttribute("listatemporadas",tempoSrvc.listaTempo());
        return "/listas/lista-temporadas"; //Usar búsqueda con el filtro "temporadas" activado
    }


    //Crear, Guardar, Borrar y Editar

    @GetMapping("/temporada/nueva-temporada")
    public String nuevo(Model modelo){
        modelo.addAttribute("temporada", new Temporada());
        return "/forms/nueva-temporada";
    }

    @PostMapping("/temporada/guardar")
    public String guardar(Temporada tempo){
        tempoSrvc.guardar(tempo);
        return "redirect:/lista-temporadas";
    }

    @GetMapping("/temporada/borrar/{id}")
    public String borrar(@PathVariable Long id){
        tempoSrvc.borrar(id);
        return "redirect:/lista-temporadas";
    }

    @GetMapping("/temporada/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo){
        Optional<Temporada> tempoOpt = tempoSrvc.buscaId(id);
        if(tempoOpt.isPresent()){
            modelo.addAttribute("temporada", tempoOpt.get());
        }
        else{
            // Si no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        return "/forms/nueva-temporada";
    }

}
