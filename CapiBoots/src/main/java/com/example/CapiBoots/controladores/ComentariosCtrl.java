package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Comentarios;
import com.example.CapiBoots.servicios.ComentariosSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ComentariosCtrl {
    @Autowired
    public ComentariosSrvcImpls comentSrvc;

    @GetMapping("/comentarios-id")
    public String accesoId(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("comentarios_id", comentSrvc.buscaId(id));
        return "comentarios-id";
    }
    //Lista de comentarios
    @GetMapping("/comentarios/lista-comentarios")
    public String listaComentarios(Model modelo){
        modelo.addAttribute("listaComentarios", comentSrvc.listaCom());
        return "/listas/lista-comentarios";
    }
    //Crear, guardar, borrar y editar
    @GetMapping("/comentarios/nuevo-comentario")
    public String nuevoComentario(Model modelo){
        modelo.addAttribute("comentario", new Comentarios());
        return "/forms/nuevo-comentario";
    }
    @PostMapping("/comentarios/guardar")
    public String guardarComentario(Comentarios comentario){
        comentSrvc.guardar(comentario);
        return "redirect:/comentarios/lista-comentarios";
    }
    @GetMapping("/comentarios/borrar/{id}")
    public String borrarComentario(@PathVariable Long id){
        comentSrvc.borrar(id);
        return "redirect:/comentarios/lista-comentarios";
    }
    @GetMapping("/comentarios/editar/{id}")
    public String editarComentario(@PathVariable Long id, Model modelo){
        Optional <Comentarios> comentOpt = comentSrvc.buscaId(id);
        if (comentOpt.isPresent()) {
            modelo.addAttribute("comentario", comentOpt.get());
        }else{
            return "error";
        }
            return "forms/nuevo-comentario";

    }
}
