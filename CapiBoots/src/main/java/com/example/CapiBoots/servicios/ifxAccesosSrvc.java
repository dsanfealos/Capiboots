package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;

import java.util.List;

public interface ifxAccesosSrvc {
    public Accesos buscaId(Long id);
    List<Accesos> listaAcces();
}
