package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.TemporadaSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TemporadaCtrl {

    @Autowired
    public TemporadaSrvcImpls tempoSrvc;

    @GetMapping("/lista-temporada")
    public String listaSeries (Model modelo){
        modelo.addAttribute("listatemporadas",tempoSrvc.listaTemp());
        return "listatempo"; //Usar búsqueda con el filtro "temporadas" activado
    }

    @GetMapping("/temporada-id")
    public String seriePorId (@PathVariable Long id, Model modelo){
        modelo.addAttribute("serie_id",tempoSrvc.buscaId(id));
        return "listatempo";    //Usar búsqueda con el nombre obtenido por la id
    }


}
