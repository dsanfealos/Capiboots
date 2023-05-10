package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxAccesosSrvc {
    public Accesos buscaId(Long id);
    Optional<List<Accesos>> listaAcces();
    List<Contenidos> buscaPendientes(Long usu);
}
