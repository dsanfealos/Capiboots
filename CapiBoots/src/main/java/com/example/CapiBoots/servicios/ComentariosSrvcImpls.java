package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Comentarios;
import com.example.CapiBoots.repositorios.ComentariosRepositorio;

import java.util.List;

public class ComentariosSrvcImpls implements ifxComentariosSrvc {
    public ComentariosRepositorio comentrepo;
    @Override
    public Comentarios buscaNombre(String nombre) {
        return null;
    }

    @Override
    public List<Comentarios> listaCom() {
        return comentrepo.findAll();
    }
}
