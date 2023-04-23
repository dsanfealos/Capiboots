package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.CategoriasSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriasCtrl {
    @Autowired
    public CategoriasSrvcImpls catSrvc;

    @GetMapping("/lista-categorias")
    public String listaCategorias(Model modelo) {
        modelo.addAttribute("listacategorias", catSrvc.listaCat());
        return "lista-categorias";
    }

    @GetMapping("/categoria-id")
    public String accesoId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categoria_id", catSrvc.buscaId(id));
        return "categoria-id";
    }
}
