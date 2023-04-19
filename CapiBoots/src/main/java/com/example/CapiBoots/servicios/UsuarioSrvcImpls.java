package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSrvcImpls implements ifxUsuarioSrvc{

    @Autowired
    private UsuarioRepositorio usurepo;


    @Override
    public Usuario buscaId(Long id) {
        return usurepo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> listaUsus() {
        return usurepo.findAll();
    }


}
