package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Usuario;

import java.util.List;

public interface ifxUsuarioSrvc {

    public Usuario buscaId(Long id);
    List<Usuario> listaUsus();
}
