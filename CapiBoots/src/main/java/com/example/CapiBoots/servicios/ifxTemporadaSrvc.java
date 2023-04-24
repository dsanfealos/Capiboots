package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Temporada;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxTemporadaSrvc {

    Optional<Temporada> buscaId(Long id);
    List<Temporada> listaTempo();

    //Guardar porque Borrar requiere un método void y Crear/Editar se definen en el controlador.

    public Temporada guardar(Temporada tempo);
}
