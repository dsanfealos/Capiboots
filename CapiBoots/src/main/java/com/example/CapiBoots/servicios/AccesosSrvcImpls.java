package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.repositorios.AccesosRepositorio;

import java.util.List;

public class AccesosSrvcImpls implements ifxAccesosSrvc{

    public AccesosRepositorio accessrepo;
    @Override
    public Accesos buscaId(Long id) {
        return accessrepo.findById(id).orElse(null);
    }
    @Override
    public List<Accesos> listaAcces() {
        return accessrepo.findAll();
    }
}
