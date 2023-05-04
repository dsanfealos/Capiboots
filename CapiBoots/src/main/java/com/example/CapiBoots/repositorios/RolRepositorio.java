package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositorio extends JpaRepository<Rol, Long> {

    Rol findByName(String rol);

}
