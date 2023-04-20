package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.repositorios.SeriesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesSrvcImpls implements ifxSeriesSrvc{

    @Autowired
    public SeriesRepositorio serierepo;
    @Override
    public Series buscaId(Long id) {
        return serierepo.findById(id).orElse(null);
    }

    @Override
    public List<Series> listaSeri() {
        return serierepo.findAll();
    }
}
