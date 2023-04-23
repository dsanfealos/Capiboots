package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepositorio extends JpaRepository<Comentarios, Long> {
}
