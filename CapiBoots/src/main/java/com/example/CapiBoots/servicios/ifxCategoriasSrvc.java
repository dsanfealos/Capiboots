package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;

import java.util.List;
import java.util.Optional;

public interface ifxCategoriasSrvc {
    Optional<Categorias> buscaId(Long id);
    List<Categorias> listaCat();

    public Categorias guardar(Categorias cat);

}
