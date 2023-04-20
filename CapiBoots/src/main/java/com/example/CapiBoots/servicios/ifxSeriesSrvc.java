package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;

public interface ifxSeriesSrvc {
    public Series buscaId(Long id);
    List<Series> listaSeri();
}
