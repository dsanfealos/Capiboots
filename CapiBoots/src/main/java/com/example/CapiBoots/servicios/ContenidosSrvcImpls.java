package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.repositorios.CategoriasRepositorios;
import com.example.CapiBoots.repositorios.ContenidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContenidosSrvcImpls implements ifxContenidosSrvc {
    @Autowired
    public ContenidosRepositorio contenidoRepo;

    //Buscar por ID
    @Override
    public Optional<Contenidos> buscarContenidoId(Long id) {
        return contenidoRepo.findById(id);
    }

    //Listar
    @Override
    public List<Contenidos> listaCont() {
        return contenidoRepo.findAll();
    }

    //Guardar y Borrar
    @Override
    public Contenidos guardar(Contenidos contenido) {
        return contenidoRepo.save(contenido);
    }

    public void borrar(Long id) {
        contenidoRepo.deleteById(id);
    }

    //Lista Pendientes
    public Object listaPend() {
        return null;
    }

    //Búsqueda libros y películas
    @Override
    public List<Contenidos> buscaCont(String keyword) {
        List<Contenidos> lista = new ArrayList<>();
        if (keyword != null) {
            lista = contenidoRepo.buscarTodos(keyword);
            return lista;
        }
        return contenidoRepo.findAll();
    }

    //Filtro de Categorías
    public List<Contenidos> filtroCategoria(String keyword) {
        List<Contenidos> lista = new ArrayList<>();
        if (keyword != null) {
            lista = contenidoRepo.buscarPorCat(keyword);
            return lista;
        }
        return contenidoRepo.findAll();
    }


    //Pendientes
    //TODO: Introducir String en direccion href
    public Optional<Long> pendientes(Long id) {
        //Contenidos contNuevo = new Contenidos();
        //buscarContenidoId(id);
        // Como utilizamos el operador ternario (también llamado Edison) y utilizamos Optional (que puede ser nulo),
        // podemos reducir las siguientes líneas a una sola
        /*
        Optional urlPendiente;
        if (contEmpezado(true) && contTerminado(false)) {
            urlPendiente = "http://localhost:8080/pendientes" + id;
        } else {
             urlPendiente = null;
        }
        return urlPendiente;
        */
        return Optional.ofNullable(contEmpezado(true) && contTerminado(false) ? id : null);
    }

    //Novedades
    public Contenidos novedades(Contenidos contNuevo) throws InterruptedException {

        contNuevo.setNovedad(true);
        System.out.println("He llegado" + contNuevo.getNovedad());
        return contNuevo;
    }

    //Botones de Pendientes
    public Boolean contEmpezado(boolean a) {


        return a;
    }

    public Boolean contTerminado(boolean b) {
        return b;
    }
}
