package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;

import java.util.List;

public interface ifxCategoriasSrvc {
    public Categorias buscaNombre(String nombre);
    List<Categorias> listaCat();

}
