package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SeriesRepositorio extends JpaRepository<Series, Long> {

    //Búsqueda de Series
    //Seleccionar todas las series donde el nombre sea el seleccionado
    @Query("SELECT s FROM Series s WHERE s.nombre LIKE %?1%")
    List<Series> buscarTodos(String keyword);
}
