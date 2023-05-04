package com.example.CapiBoots.repositorios;

import com.example.CapiBoots.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE %?1%")
    public List<Usuario> buscarTodos(String keyword);

    Usuario findByNombreUsuario (String nombre_usuario);

    Usuario findByCorreo (String correo);

    Usuario findByTokenRestaurarContra(String token_restaurar_contra);

}
