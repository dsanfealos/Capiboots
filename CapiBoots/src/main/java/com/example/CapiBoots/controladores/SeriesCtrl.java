package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.servicios.PagosSrvcImpls;
import com.example.CapiBoots.servicios.SeriesSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SeriesCtrl {

    @Autowired
    public SeriesSrvcImpls serieSrvc;


    @GetMapping("/lista-series")
    public String listaSeries (Model modelo){
        modelo.addAttribute("listaseries",serieSrvc.listaSeri());
        return "listaseries"; //Usar búsqueda con el filtro "series" activado
    }

    @GetMapping("/series-id")
    public String seriePorId (@PathVariable Long id, Model modelo){
        modelo.addAttribute("serie_id",serieSrvc.buscaId(id));
        return "listaseries";    //Usar búsqueda con el nombre obtenido por la id
    }

    //Crear, Guardar, Borrar y Editar

    @GetMapping("/serie/nueva-serie")
    public String nuevoUsu(Model modelo){
        modelo.addAttribute("serie", new Series());
//        modelo.addAttribute("fragmentName", "fragment-customer-form");
        return "nueva-serie";
    }

    @PostMapping("/serie/guardar")
    public String guardar(Series seri){
        serieSrvc.guardar(seri);
        return "redirect:/lista-series";
    }

    @GetMapping("/serie/borrar/{id}")
    public String borrar(@PathVariable Long id){
        serieSrvc.borrar(id);
        return "redirect:/lista-series";
    }

    @GetMapping("/serie/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo){
        Optional<Series> seriOpt = serieSrvc.buscaId(id);
        if(seriOpt.isPresent()){
            modelo.addAttribute("serie", seriOpt.get());
        }
        else{
            // Si el cliente no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        return "nueva-serie";
    }

}
