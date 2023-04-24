package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepositorio extends JpaRepository<Series, Long> {

    @Query("SELECT s FROM Series s WHERE s.nombre LIKE %?1%")
    public List<Series> buscarTodos(String keyword);
}
