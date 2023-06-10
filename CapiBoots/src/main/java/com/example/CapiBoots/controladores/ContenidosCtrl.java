package com.example.CapiBoots.controladores;

import com.example.CapiBoots.modelos.*;
import com.example.CapiBoots.repositorios.ContenidosRepositorio;
import com.example.CapiBoots.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ContenidosCtrl {

    @Autowired
    private ContenidosSrvcImpls contenidosSrvc;

    @Autowired
    private ContenidosRepositorio contenidosRepo;

    @Autowired
    private SeriesSrvcImpls serieSrvc;

    @Autowired
    private TemporadaSrvcImpls tempoSrvc;

    @Autowired
    private AccesosSrvcImpls accessSrvc;

    @Autowired
    private UsuarioSrvcImpls usuSrvc;

    @Autowired
    private CategoriasSrvcImpls catSrvc;

    //Direcciones de showbox, bookbox y moviebox. Aplicamos pendientes a cada uno.

    @GetMapping("/showbox")
    public String showbox(Model modelo) {
        modelo.addAttribute("titulo", "Showbox");
        return "showbox";
    }

    @GetMapping("/bookbox")
    public String bookbox(Model modelo) {
        modelo.addAttribute("titulo", "BookBox");
        return "bookbox";
    }

    @GetMapping("/moviebox")
    public String moviebox(Principal principal, Model modelo) {
        //De esta forma, obtenemos el usuario en cuestión que está viendo Moviebox
        String usuID = principal.getName();
        Usuario user =  usuSrvc.buscaPorNombre(usuID);
        Long id = user.getId();
        //Usando la ID del usuario, buscamos sus pendientes
        modelo.addAttribute("pendientes",accessSrvc.buscaPendientes(id));
        modelo.addAttribute("titulo", "Moviebox");
        return "moviebox";
    }

    //Búsqueda (contenido + series)
    @GetMapping("/busqueda")
    public String busqueda(@Param("keyword") String keyword, Model modelo) {
        //Utilizamos el servicio y el atributo por separado, ya que
        // contenido(libros, películas y capítulos) está en una tabla distinta a series
        List<Series> buscaseri = serieSrvc.buscaSeri(keyword);
        List<Contenidos> buscacont = contenidosSrvc.buscaCont(keyword);
        modelo.addAttribute("listaseries", buscaseri);
        modelo.addAttribute("listaContenidos", buscacont);
        return "busqueda";
    }

    //Filtro de Categorias
    @GetMapping("/busqueda/categoria")
    public String filtroCat(@Param("keyword") String keyword, Model modelo) {
        List<Contenidos> buscacont = contenidosSrvc.filtroCategoria(keyword);
        modelo.addAttribute("listaContenidos", buscacont);
        return "busqueda";
    }

    //Lista de contenidos
    @GetMapping("/contenido/lista-contenidos")
    public String listaContenidos(Model modelo) {
        modelo.addAttribute("listaseries",serieSrvc.listaSeri());
        modelo.addAttribute("listaContenidos", contenidosSrvc.listaCont());
        return "/listas/lista-contenidos";
    }

    //Crear, guardar, borrar y editar
    @GetMapping("/contenido/nuevo-contenido")
    public String crearContenido(Model modelo){
        Contenidos cont = new Contenidos();
        modelo.addAttribute("contenido", cont);
        List<Categorias> listacat = catSrvc.listaCat();
        modelo.addAttribute("listacategorias",listacat);
        return "/forms/nuevo-contenido";
    }

    @PostMapping("/contenido/guardar")
    public String guardarContenido(Contenidos contenido) {
        contenido.setNovedad(Boolean.TRUE);
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
        List<Categorias> listacat = catSrvc.listaCat();
        modelo.addAttribute("listacategorias",listacat);
        return "forms/nuevo-contenido";
    }

    //Listado de pendientes
    @GetMapping("/contenido/lista-pendientes")
    public String listaPendientes(Model modelo) {
        modelo.addAttribute("listaPendientes", contenidosSrvc.listaPend());
        return "/listas/lista-pendientes";
    }

    //Contenido/Serie pendiente específico
    @GetMapping("/pendientes/{id}")
    public String pendientes(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("pendientes", contenidosSrvc.pendientes(id));
        return "redirect:/contenido/lista-contenidos";
    }

    //Reproductor de Contenido (películas y libros)
    @GetMapping("/reproducir/{id}")
    public String reproducir(@PathVariable Long id, Model modelo) throws IOException {
        Optional<Contenidos> cont = contenidosSrvc.buscarContenidoId(id);

        if (cont.isPresent()){
            Contenidos cont1 = cont.get();

            modelo.addAttribute("cont", cont1);
        }
        if (cont.get().getRutaVideo() != null){
            String  mime =  Files.probeContentType(new File(cont.get().getRutaVideo()).toPath());
            modelo.addAttribute("mime", mime);
        }
        modelo.addAttribute("contenido", id);
        return "vistaReproductorPeliculas";
    }

    //Reproductor para capítulos
    @GetMapping("/reproducir-t/{id}")
    public String reproducirSeries(@PathVariable Long id, Model modelo) {
        Optional<Contenidos> cont = contenidosSrvc.buscarContenidoId(id);

        if (cont.isPresent()){
            Contenidos cont1 = cont.get();
            Temporada temp1 = cont1.getIdtemporada();
            modelo.addAttribute("temp", temp1);
            modelo.addAttribute("cont", cont1);
        }
        return "vistaReproductorSerie";
    }

    //Presentación de Película o Libro
    @GetMapping("/contenido/{id}")
    public String contPpal (@PathVariable Long id, Model modelo){
        Optional<Contenidos> cont = contenidosSrvc.buscarContenidoId(id);

        if (cont.isPresent()){
            Contenidos cont1 = cont.get();
            modelo.addAttribute("cont", cont1);
        }
        modelo.addAttribute("contenido", id);

        return "contenido";
    }

    //Presentación de Serie
    @GetMapping("/serie/{id}")
    public String contPpalSerie (@PathVariable Long id, Model modelo){
        Optional<Series> seri = serieSrvc.buscaId(id);

        if (seri.isPresent()){
            Series seri1 = seri.get();
            modelo.addAttribute("seri", seri1);
        }
        modelo.addAttribute("series", id);

        List<Temporada> listTempo = tempoSrvc.listaTempoPorSerie(id);
        modelo.addAttribute("listaTempo", listTempo);
        return "contenido-serie";
    }

    //Mostrar una Temporada de esa Serie
    @GetMapping("/temporada/{id}")
    public String contPpalSerieTempo (@PathVariable Long id, Model modelo){
        Optional<Temporada> temp = tempoSrvc.buscaId(id);

        if (temp.isPresent()){
            Temporada temp1 = temp.get();
            Series seri1 = temp1.getSerie();
            modelo.addAttribute("temp", temp1);
            modelo.addAttribute("seri", seri1);
            List<Contenidos> listCon = contenidosRepo.findByIdtemporada(temp1);
            modelo.addAttribute("listCon", listCon);
            List<Temporada> listTempo = tempoSrvc.listaTempoPorSerie(temp1.getSerie().getId());
            modelo.addAttribute("listaTempo", listTempo);
        }
        modelo.addAttribute("temporadaid", id);
        return "contenido-serie-temporada";
    }
}
