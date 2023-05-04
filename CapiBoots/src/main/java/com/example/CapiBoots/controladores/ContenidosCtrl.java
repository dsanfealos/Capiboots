package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.servicios.ContenidosSrvcImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ContenidosCtrl {

        @Autowired
        private ContenidosSrvcImpls contenidosSrvc;

        @GetMapping ("/guardarContenido")
        public String guardarContenido(Model modelo){
            modelo.addAttribute("guardarContenidos", contenidosSrvc.guardarContenido());
            return "guardarContenidos";
        }
        @GetMapping ("/eliminarContenido")
        public String eliminarContenido(Model modelo){
            modelo.addAttribute("eliminarContenidos", contenidosSrvc.eliminarContenido());
            return "eliminarContenidos";
        }
        @GetMapping ("/actualizarContenido")
        public String actualizarContenido(Model modelo){
            modelo.addAttribute("actualizarContenidos", contenidosSrvc.actualizarContenido());
            return "actualizarContenidos";
        }
        @GetMapping ("/buscarContenido")
        public String buscarContenido(Model modelo){
            modelo.addAttribute("buscarContenidos", contenidosSrvc.buscarContenido());
            return "buscarContenidos";
        }
        @GetMapping ("/showbox")
        public String Showbox(Model modelo){
            modelo.addAttribute("titulo", "Showbox");
            return "moviebox";
        }
        @GetMapping("/bookbox")
        public String bookbox(Model modelo){

            modelo.addAttribute("titulo","BookBox");
            return "bookbox";
        }
        @GetMapping("/moviebox")
        public String showbox(Model modelo){

            modelo.addAttribute("titulo","Moviebox");
            return "moviebox";
        }
        @GetMapping("/favoritos")
        public String favoritos(Model modelo){

            modelo.addAttribute("titulo","Favoritos");
            return "favoritos";
        }
        @Controller
        public class BusquedaCtrl {

            @GetMapping("/busqueda")
            public String busqueda(Model modelo){

                return "busqueda";
            }
        }

        //Lista de contenidos
        @GetMapping ("/contenido/lista-contenidos")
        public String listaContenidos(Model modelo){
            modelo.addAttribute("listaContenidos", contenidosSrvc.listaCont());
            return "/listas/lista-contenidos";
        }
        //Crear, guardar, borrar y editar
    @GetMapping("/contenido/nuevo-contenido")
    public String crearContenido(Model modelo) {
        modelo.addAttribute("contenido", new Contenidos());
        return "/forms/nuevo-contenido";
    }
    @PostMapping ("/contenido/guardar")
    public String guardarContenido(Contenidos contenido) {
        contenidosSrvc.guardar(contenido);
        return "redirect:/contenido/lista-contenidos";
    }
    @GetMapping("/contenido/borrar/{id}")
    public String borrarContenido(@PathVariable Long id) {
        contenidosSrvc.borrar(id);
        return "redirect:/contenido/lista-contenidos";
    }
    @GetMapping("/contenido/editar/{id}")
    public String editarContenido(@PathVariable Long id, Model modelo) {
        Optional<Contenidos> contOptional = contenidosSrvc.buscarContenidoId(id);
        if (contOptional.isPresent()) {
            modelo.addAttribute("contenido", contOptional.get());
        } else {
            return "error";
        }
        return "forms/nuevo-contenido";
    }

    }
