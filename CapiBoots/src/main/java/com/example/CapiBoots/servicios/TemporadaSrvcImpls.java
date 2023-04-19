package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Temporada;
import com.example.CapiBoots.repositorios.TemporadaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaSrvcImpls implements ifxTemporadaSrvc{

    @Autowired
    public TemporadaRepositorio temporepo;


    @Override
    public Temporada buscaId(Long id) {
        return temporepo.findById(id).orElse(null);
    }

    @Override
    public List<Temporada> listaTemp() {
        return temporepo.findAll();
    }
}
