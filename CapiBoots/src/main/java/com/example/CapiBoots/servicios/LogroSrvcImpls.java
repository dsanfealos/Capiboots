package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Logro;
import com.example.CapiBoots.repositorios.LogroRepositorio;

import java.util.List;

public class LogroSrvcImpls implements ifxLogroSrvc{

    public LogroRepositorio logroRepo;
    @Override
    public Logro buscarPorId(Long id) {
        return logroRepo.findById(id).orElse(null);
    }

    @Override
    public List<Logro> listaLogro() {
        return logroRepo.findAll() ;
    }
}
