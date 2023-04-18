package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;

import java.util.List;

public interface ifxAccesosSrvc {
    public Accesos buscaNombre(String nombre);
    List<Accesos> listaAcces();
}
