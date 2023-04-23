package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.CategoriasSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ComentariosCtrl {
    @Autowired
    public CategoriasSrvcImpls comentSrvc;

    @GetMapping("/lista-comentarios")
    public String listaComentarios(Model modelo) {
        modelo.addAttribute("listacomentarios", comentSrvc.listaCat());
        return "lista-comentarios";
    }

    @GetMapping("/comentarios-id")
    public String accesoId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("comentarios_id", comentSrvc.buscaId(id));
        return "comentarios-id";
    }
}
