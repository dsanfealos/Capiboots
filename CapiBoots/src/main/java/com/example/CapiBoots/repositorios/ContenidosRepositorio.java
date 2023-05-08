package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContenidosRepositorio extends JpaRepository<Contenidos, Long> {

    @Query("SELECT c FROM Contenidos c WHERE c.nombre LIKE %?1% AND c.idserie IS NULL")//Para obtener libros y películas pero no capítulos
    public List<Contenidos> buscarTodos(String keyword);
//    @Query("SELECT c FROM Contenidos c WHERE Categorias.nombre LIKE %?1%")//Búsqueda por filtros
//    public List<Contenidos> buscarPorCat(String keyword);
}
