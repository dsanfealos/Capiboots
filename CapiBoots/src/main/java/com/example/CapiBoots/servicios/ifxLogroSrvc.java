package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Logro;

import java.util.List;

public interface ifxLogroSrvc {
    public Logro buscarPorId(Long id);

    List<Logro> listaLogro();
}
