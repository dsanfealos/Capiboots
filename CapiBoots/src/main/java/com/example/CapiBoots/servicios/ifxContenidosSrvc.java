package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Contenidos;

import java.util.List;
import java.util.Optional;

public interface ifxContenidosSrvc {


    Optional<Contenidos> buscarContenidoId(Long id);
    public Contenidos guardarContenido();
    public Contenidos  eliminarContenido();
    public Contenidos actualizarContenido();
    public Contenidos  buscarContenido();

    List<Contenidos> listaCont();

    public Contenidos guardar(Contenidos contenido);
}
