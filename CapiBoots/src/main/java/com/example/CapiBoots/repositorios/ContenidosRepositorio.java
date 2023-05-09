package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Contenidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContenidosRepositorio extends JpaRepository<Contenidos, Long> {

    @Query("SELECT c FROM Contenidos c WHERE c.nombre LIKE %?1% AND c.idserie IS NULL") //Para obtener libros y peliculas pero no capitulos de series
    public List<Contenidos> buscarTodos(String keyword);

    //Busqueda por filtros
    @Query("SELECT c FROM Contenidos c JOIN c.categorias cat WHERE cat.nombre LIKE %?1%")
    public List<Contenidos> buscarPorCat(String keyword);







}
