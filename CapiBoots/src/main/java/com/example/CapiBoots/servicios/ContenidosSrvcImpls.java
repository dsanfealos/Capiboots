package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.repositorios.ContenidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidosSrvcImpls implements ifxContenidosSrvc{
    @Autowired
    public ContenidosRepositorio contenidoRepo;
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



    @Override
    public List<Contenidos> listaCont() {
        return contenidoRepo.findAll();
    }
}
