package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Medio;
import com.example.CapiBoots.repositorios.MedioRepositorio;

import java.util.List;

public class MedioSrvcImpls implements ifxMedioSrvc{
    public MedioRepositorio medioRepo;
    @Override
    public Medio guardarDatos() {
        return null;
    }

    @Override
    public Medio eliminarDatos() {
        return null;
    }

    @Override
    public List<Medio> listaMedio() {
        return medioRepo.findAll();
    }
}
