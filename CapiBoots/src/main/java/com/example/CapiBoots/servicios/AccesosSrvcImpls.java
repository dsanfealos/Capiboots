package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.AccesosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccesosSrvcImpls implements ifxAccesosSrvc{
    @Autowired
    public AccesosRepositorio accessrepo;
    @Override
    public Accesos buscaId(Long id) {
        return accessrepo.findById(id).orElse(null);
    }

    public Accesos guardar(Accesos acceso) {
        return accessrepo.save(acceso);
    }

    public Accesos buscaIdUsuAndIdCont(Long usu, Long cont){
        return accessrepo.buscarAccesos(usu, cont);
    }
    @Override
    public List<Accesos> listaAcces() {
        return accessrepo.findAll();
    }

    @Override
    public List<Contenidos> buscaPendientes(Long usu) {
        return accessrepo.buscarPendientes(usu);
    }
}
