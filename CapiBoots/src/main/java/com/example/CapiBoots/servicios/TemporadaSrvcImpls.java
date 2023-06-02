package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Temporada;
import com.example.CapiBoots.repositorios.TemporadaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemporadaSrvcImpls implements ifxTemporadaSrvc{

    @Autowired
    public TemporadaRepositorio temporepo;


    @Override
    public Optional<Temporada> buscaId(Long id) {
        return temporepo.findById(id);
    }

    //Listar
    @Override
    public List<Temporada> listaTempo() {
        return temporepo.findAll();
    }

    //Guardar y Borrar

    @Override
    public Temporada guardar(Temporada tempo) {
        return temporepo.save(tempo);
    }

    public void borrar(Long id) {
        temporepo.deleteById(id);
    }

    //Lista de temporadas por idSerie
    public List<Temporada> listaTempoPorSerie (Long idserie){
        List<Temporada> lista = new ArrayList<>();
        if (idserie != null) {
            lista = temporepo.listaTemporada(idserie);
            return lista;
        }
        return temporepo.findAll();
    }
}
