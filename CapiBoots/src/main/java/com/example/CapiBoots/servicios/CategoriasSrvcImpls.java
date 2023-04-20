package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;
import com.example.CapiBoots.repositorios.CategoriasRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriasSrvcImpls implements ifxCategoriasSrvc {
    @Autowired
    public CategoriasRepositorios catrepo;
    @Override
    public Categorias buscaId(Long id) {
        return catrepo.findById(id).orElse(null);
    }
    @Override
    public List<Categorias> listaCat() {
        return catrepo.findAll();
    }
}
