package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxSeriesSrvc {
    Optional<Series> buscaId(Long id);
    List<Series> buscaSeri(String keyword);
    List<Series> listaSeri();

    //Crear, Guardar, Borrar y Editar

    public Series nuevo(Series seri);

    public Series guardar(Series seri);

    public Series editar(Series seri);

}
