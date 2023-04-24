package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxSeriesSrvc {
    Optional<Series> buscaId(Long id);
    List<Series> buscaSeri(String keyword);
    List<Series> listaSeri();

    //Guardar porque Borrar requiere un método void y Crear/Editar se definen en el controlador.

    public Series guardar(Series seri);

}
