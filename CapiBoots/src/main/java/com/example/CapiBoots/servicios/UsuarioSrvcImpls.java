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

    //Buscador por palabra clave
    @Override
    public List<Usuario> buscaUsus(String keyword) {
        if (keyword != null) {
            return usurepo.buscarTodos(keyword);
        }
        return usurepo.findAll();
    }

    //Listar
    @Override
    public List<Usuario> listaUsus() {
        return usurepo.findAll();
    }

    //Guardar y Borrar porque Crear/Editar se definen en el controlador.

    @Override
    public Usuario guardar(Usuario user) {
        return usurepo.save(user);
    }

    public void borrar(Long id) {
        usurepo.deleteById(id);
    }

}
