package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxUsuarioSrvc {

    Optional<Usuario> buscaId(Long id);
    List<Usuario> buscaUsus(String keyword);
    List<Usuario> listaUsus();

    //Guardar porque Borrar requiere un método void y Crear/Editar se definen en el controlador.

    public Usuario guardar(Usuario user);
}
