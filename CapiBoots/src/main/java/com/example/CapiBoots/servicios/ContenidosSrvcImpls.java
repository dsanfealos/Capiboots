package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.repositorios.ContenidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidosSrvcImpls implements ifxContenidosSrvc{
    @Autowired
    public ContenidosRepositorio contenidoRepo;

    @Override
    public Optional<Contenidos> buscarContenidoId(Long id) {
        return contenidoRepo.findById(id);
    }

    @Override
    public Contenidos guardarContenido() {
        return null;
    }

    @Override
    public Contenidos eliminarContenido() {
        return null;
    }

    @Override
    public Contenidos actualizarContenido() {
        return null;
    }

    @Override
    public Contenidos buscarContenido() {
        return null;
    }



    //Listar
    @Override
    public List<Contenidos> listaCont() {
        return contenidoRepo.findAll();
    }
    //Guardar
    @Override
    public Contenidos guardar(Contenidos contenido) {
        return contenidoRepo.save(contenido);
    }

    @Override
    public Object listaNovedades() {
        return null;
    }

    //Borrar
    public void borrar(Long id){
        contenidoRepo.deleteById(id);
    }

    public Object listaPend() {
        return null;
    }

   //Pendientes
    //TODO: Introducir String en direccion href
    public Optional<Long> pendientes (Long id){
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

    //Campos extra
    public Boolean contEmpezado(boolean a) {


        return a;
    }
    public Boolean contTerminado(boolean b) {
        return b;
    }
}
