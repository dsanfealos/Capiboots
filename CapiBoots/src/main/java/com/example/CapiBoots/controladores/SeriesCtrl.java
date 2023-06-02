package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.repositorios.SeriesRepositorio;
import com.example.CapiBoots.servicios.SeriesSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SeriesCtrl {

    @Autowired
    public SeriesSrvcImpls serieSrvc;


    //Listas de Series
    @GetMapping("/lista-series")
    public String listaSeries (Model modelo){
        modelo.addAttribute("listaseries",serieSrvc.listaSeri());
        return "/listas/lista-series";
    }

    //Búsqueda
    @GetMapping("/buscarseri")
    public String buscarSeri(@Param("keyword") String keyword , Model modelo){
        List<Series> buscaseri = serieSrvc.buscaSeri(keyword);
        modelo.addAttribute("listaseries", buscaseri);
        return "/listas/lista-contenidos";
    }

    //Crear, Guardar, Borrar y Editar

    @GetMapping("/serie/nueva-serie")
    public String nuevo(Model modelo){
        modelo.addAttribute("serie", new Series());
        return "/forms/nuevo-contenido";
    }

    @PostMapping("/serie/guardar")
    public String guardar(Series seri){
        serieSrvc.guardar(seri);
        return "redirect:/lista-contenidos";
    }

    @GetMapping("/serie/borrar/{id}")
    public String borrar(@PathVariable Long id){
        serieSrvc.borrar(id);
        return "redirect:/lista-contenidos";
    }

    @GetMapping("/serie/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo){
        Optional<Series> seriOpt = serieSrvc.buscaId(id);
        if(seriOpt.isPresent()){
            modelo.addAttribute("serie", seriOpt.get());
        }
        else{
            // Si no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        return "/forms/nuevo-contenido";
    }

}
