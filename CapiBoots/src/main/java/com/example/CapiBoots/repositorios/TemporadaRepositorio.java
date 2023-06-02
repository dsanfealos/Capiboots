package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface TemporadaRepositorio extends JpaRepository<Temporada, Long> {

    //Lista de temporadas de una Serie
    //Seleccionar todas las temporadas donde la id.serie sea la seleccionada
    @Query("SELECT t FROM Temporada t WHERE t.serie.id = ?1")
    List<Temporada> listaTemporada(Long idserie);
}
