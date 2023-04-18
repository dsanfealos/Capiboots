package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;

import java.util.List;

public interface ifxCategoriasSrvc {
    public Categorias buscaId(Long id);
    List<Categorias> listaCat();

}
