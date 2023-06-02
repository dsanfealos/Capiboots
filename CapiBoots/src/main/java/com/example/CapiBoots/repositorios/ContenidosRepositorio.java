package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Categorias;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Temporada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContenidosRepositorio extends JpaRepository<Contenidos, Long> {

    //Búsqueda (contenido sin capítulos)
    //Seleccionar todos los Contenidos donde el nombre sea el seleccionado y la id.serie = null
    @Query("SELECT c FROM Contenidos c WHERE c.nombre LIKE %?1% AND c.idserie IS NULL")//Para obtener libros y películas pero no capítulos
    public List<Contenidos> buscarTodos(String keyword);

    //Busqueda por filtros
    //Seleccionar todos los Contenidos donde el nombre de una de las categorías asociadas sea el seleccionado
    @Query("SELECT c FROM Contenidos c JOIN c.categorias cat WHERE cat.nombre LIKE %?1%")
    List<Contenidos> buscarPorCat(String keyword);


    //Novedades
    // Seleccionamos todos los contenidos que tienen la propiedad "novedad" = true y tiene más de 7 días
    //REVISAR QUERY
    @Query("UPDATE Contenidos c SET c.novedad = false WHERE c.novedad AND c.fechaAlta < CURRENT_DATE - 7")
    void quitaNovedades();

    //Capítulos
    //Buscar por el id de temporada (sólo un conjunto de caps lo compartirá)
    List<Contenidos> findByIdtemporada(Temporada idtemporada);
}
