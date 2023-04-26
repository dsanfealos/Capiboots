package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Contenidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContenidosRepositorio extends JpaRepository<Contenidos, Long> {
}
