package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Accesos;
import com.example.CapiBoots.modelos.Contenidos;
import com.example.CapiBoots.modelos.Usuario;
import com.example.CapiBoots.repositorios.AccesosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccesosSrvcImpls implements ifxAccesosSrvc{
    @Autowired
    public AccesosRepositorio accessrepo;

    @Override
    public Accesos buscaId(Long id) {
        return accessrepo.findById(id).orElse(null);
    }

    //Guardar
    public Accesos guardar(Accesos acceso) {
        return accessrepo.save(acceso);
    }

    // Devuelve el último acceso de un usuario a un contenido
    public Optional<Accesos> buscaUltimoAcceso(Long usu, Long cont){
        // obtenemos la lista de todos los accesos del usuario al contenido indicado
        List<Accesos> lista = accessrepo.buscarAccesos(usu, cont);
        // Obtenemos el último de la lista como Optional, ya que puede no existir (y ser nulo)
        Optional<Accesos> ult = Optional.ofNullable(lista.get(lista.size()-1));
        return ult;
    }

    //Lista
    @Override
    public Optional<List<Accesos>> listaAcces() {
        return Optional.ofNullable(accessrepo.findAll());
    }

    //Búsqueda de pendientes
    @Override
    public List<Contenidos> buscaPendientes(Long usu) {
        return accessrepo.buscarPendientes(usu);
    }

}
