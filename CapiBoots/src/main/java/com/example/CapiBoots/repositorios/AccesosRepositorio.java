package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Series;
import com.example.CapiBoots.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccesosRepositorio extends JpaRepository<Accesos, Long> {

    @Query("SELECT a FROM Accesos a WHERE a.idUsuario=?1 AND NOT a.terminado")
    List<Contenidos> buscarPendientes(Long usu);

    @Query("SELECT a FROM Accesos a WHERE a.idUsuario=?1 AND a.idContenido=?2")
    Accesos buscarAccesos(Long usu, Long contenido);

}
