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

    @Query("SELECT a.contenido FROM Accesos a WHERE a.usuario=?1 AND NOT a.terminado")  //TODO Preguntar si NOT a.terminado es igual a a.terminado = FALSE
    List<Contenidos> buscarPendientes(Long usu);

    @Query("SELECT a.contenido FROM Accesos a WHERE a.usuario.id=?1 AND a.contenido.id=?2 ORDER BY a.id")
    List<Accesos> buscarAccesos(Long usu, Long contenido);

}
