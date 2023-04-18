package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Medio;

import java.util.List;

public interface ifxMedioSrvc {
    public Medio guardarDatos();
    public Medio eliminarDatos();

    List<Medio> listaMedio();

}
