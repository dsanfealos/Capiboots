package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSrvcImpls implements ifxUsuarioSrvc{

    @Autowired
    private UsuarioRepositorio usurepo;


    @Override
    public Optional<Usuario> buscaId(Long id) {
        return usurepo.findById(id);
    }

    @Override
    public List<Usuario> buscaUsus(String keyword) {
        if (keyword != null) {
            return usurepo.buscarTodos(keyword);
        }
        return usurepo.findAll();
    }

    @Override
    public List<Usuario> listaUsus() {
        return usurepo.findAll();
    }

    //Crear, Guardar, Borrar y Editar
    @Override
    public Usuario nuevo(Usuario user) {

        return null;
    }

    @Override
    public Usuario guardar(Usuario user) {
        return usurepo.save(user);
    }

    public void borrar(Long id) {
        usurepo.deleteById(id);
    }

    @Override
    public Usuario editar(Usuario user) {

        return null;
    }


}
