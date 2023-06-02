package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Categorias;
import com.example.CapiBoots.repositorios.CategoriasRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasSrvcImpls implements ifxCategoriasSrvc {
    @Autowired
    public CategoriasRepositorios catrepo;
    @Override
    public Optional<Categorias> buscaId(Long id) {
        return catrepo.findById(id);
    }
    //Lista
    @Override
    public List<Categorias> listaCat() {
        return catrepo.findAll();
    }

    //Guardar y borrar
    @Override
    public Categorias guardar(Categorias cat) {
        return catrepo.save(cat);
    }

    public void borrar (Long id) {
        catrepo.deleteById(id);
    }
}
