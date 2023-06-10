package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccesosRepositorio extends JpaRepository<Accesos, Long> {

    //Búsqueda de pendientes.
    //Seleccionar Contenido de Accesos donde el id del Usuario sea el seleccionado y Terminado = null
    @Query("SELECT a.contenido FROM Accesos a WHERE a.usuario.id=?1 AND a.terminado = false ")  //TODO Conseguir para series, libros y no cap?
    List<Contenidos> buscarPendientes(Long usu);

    //Búsuqeda de accesos.
    //Seleccionar Contenido de Accesos donde el id del Usuario sea el seleccionado y el id del contenido sea el segundo seleccionado.
    //Lo anterior ordenado por id de accesos
    @Query("SELECT a FROM Accesos a WHERE a.usuario.id=?1 AND a.contenido.id=?2 ORDER BY a.id")
    List<Accesos> buscarAccesos(Long usu, Long contenido);

}
