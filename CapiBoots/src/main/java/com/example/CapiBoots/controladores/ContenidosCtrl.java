package com.example.CapiBoots.controladores;

import com.example.CapiBoots.servicios.ContenidosSrvcImpls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class ContenidosCtrl {
    @Controller
    @RequestMapping("/contenidos")
    public class ContenidoCtrl {

        private ContenidosSrvcImpls contenidosSrvc;

        @GetMapping ({"", "/"})
        public String contenidos(Model modelo){
            modelo.addAttribute("titulo", "contenidos");
            return "contenidos";
        }
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
        @GetMapping ("/listaCont")
        public String listaCont(Model modelo){
            modelo.addAttribute("listaCont", contenidosSrvc.listaCont());
            return "listaCont";
        }
        @GetMapping ("/showbox")
        public String Showbox(Model modelo){
            modelo.addAttribute("titulo", "Showbox");
            return "Showbox";
        }
        @GetMapping("/bookbox")
        public String bookbox(Model modelo){

            modelo.addAttribute("titulo","BookBox");
            return "bookbox";
        }
        @GetMapping("/showboox")
        public String showbox(Model modelo){

            modelo.addAttribute("titulo","Showbox");
            return "showbox";
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
    }

    }
