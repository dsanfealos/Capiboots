package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Comentarios;
import com.example.CapiBoots.repositorios.ComentariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentariosSrvcImpls implements ifxComentariosSrvc {
    @Autowired
    public ComentariosRepositorio comentrepo;
    @Override
    public Comentarios buscaId(Long id) {
        return comentrepo.findById(id).orElse(null);
    }
    @Override
    public List<Comentarios> listaCom() {
        return comentrepo.findAll();
    }
}
