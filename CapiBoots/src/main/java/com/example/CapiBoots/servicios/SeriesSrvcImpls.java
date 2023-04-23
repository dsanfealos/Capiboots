package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.repositorios.SeriesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesSrvcImpls implements ifxSeriesSrvc{

    @Autowired
    public SeriesRepositorio serierepo;

    @Override
    public Optional<Series> buscaId(Long id) {
        return serierepo.findById(id);
    }

    @Override
    public List<Series> buscaSeri(String keyword) {
        if (keyword != null) {
            return serierepo.buscarTodos(keyword);
        }
        return serierepo.findAll();
    }

    @Override
    public List<Series> listaSeri() {
        return serierepo.findAll();
    }

    //Crear, Guardar, Borrar y Editar
    @Override
    public Series nuevo(Series seri) {
        return null;
    }

    @Override
    public Series guardar(Series seri) {
        return serierepo.save(seri);
    }

    public void borrar(Long id) {
        serierepo.deleteById(id);
    }

    @Override
    public Series editar(Series seri) {
        return null;
    }
}
