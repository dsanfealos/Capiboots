package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;

import java.util.List;

public interface ifxAccesosSrvc {
    public Accesos buscaId(Long id);
    List<Accesos> listaAcces();
    List<Contenidos> buscaPendientes(Long usu);
}
