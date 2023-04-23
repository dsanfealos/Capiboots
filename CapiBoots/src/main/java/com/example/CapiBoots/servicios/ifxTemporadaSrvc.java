package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Temporada;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;

public interface ifxTemporadaSrvc {

    public Temporada buscaId(Long id);
    List<Temporada> listaTemp();
}
