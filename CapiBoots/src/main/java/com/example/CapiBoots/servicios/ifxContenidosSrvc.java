package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Contenidos;

import java.util.List;

public interface ifxContenidosSrvc {

    public Contenidos guardarContenido();
    public Contenidos  eliminarContenido();
    public Contenidos actualizarContenido();
    public Contenidos  buscarContenido();

    List<Contenidos> listaCont();
}
