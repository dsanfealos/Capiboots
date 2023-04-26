package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Logro;

import java.util.List;
import java.util.Optional;

public interface ifxLogroSrvc {

    Optional<Logro> buscarLogroId(Long id);
    public Logro buscarPorId(Long id);

    List<Logro> listaLogro();

    public Logro guardarLogro(Logro logro);

    //Guardar
    Logro guardar(Logro logro);


    Logro crear(Logro logro);
}
