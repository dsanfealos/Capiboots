package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxUsuarioSrvc {

    Optional<Usuario> buscaId(Long id);
    List<Usuario> buscaUsus(String keyword);
    List<Usuario> listaUsus();

    //Crear, Guardar, Borrar y Editar

    public Usuario nuevo(Usuario user);

    public Usuario guardar(Usuario user);


    public Usuario editar(Usuario user);
}
