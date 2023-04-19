package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.PagosSrvcImpls;
import com.example.CapiBoots.servicios.SeriesSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SeriesCtrl {

    @Autowired
    public SeriesSrvcImpls serieSrvc;


    @GetMapping("/lista-series")
    public String listaSeries (Model modelo){
        modelo.addAttribute("listaserie",serieSrvc.listaSeri());
        return "listaseries"; //Usar búsqueda con el filtro "series" activado
    }

    @GetMapping("/series-id")
    public String seriePorId (@PathVariable Long id, Model modelo){
        modelo.addAttribute("serie_id",serieSrvc.buscaId(id));
        return "listaseries";    //Usar búsqueda con el nombre obtenido por la id
    }

}
