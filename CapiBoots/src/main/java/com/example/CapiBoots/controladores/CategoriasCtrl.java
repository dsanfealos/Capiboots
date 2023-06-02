package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Categorias;
import com.example.CapiBoots.servicios.CategoriasSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CategoriasCtrl {
    @Autowired
    public CategoriasSrvcImpls catSrvc;


    //Lista
    @GetMapping("/lista-categorias")
    public String listacategorias(Model modelo) {
        modelo.addAttribute("listacategorias", catSrvc.listaCat());
        return "/listas/lista-cat";

    }

    //Crear, Guardar, Borrar y Editar

    @GetMapping("/categorias/nueva-categoria")
    public String nuevo(Model modelo) {
        modelo.addAttribute("categoria", new Categorias());
        return "/forms/nueva-categoria";
    }

    @PostMapping("/categorias/guardar")
    public String guardar(Categorias cat) {
        catSrvc.guardar(cat);
        return "redirect:/lista-categorias";
    }

    @GetMapping("/categoria/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        catSrvc.borrar(id);
        return "redirect:/lista-categorias";
    }

    @GetMapping("/categoria/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Categorias> catOpt = catSrvc.buscaId(id);
        if (catOpt.isPresent()) {
            modelo.addAttribute("categoria", catOpt.get());
        } else {
            // Si no existe, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        return "/forms/nueva-categoria";
    }
}

