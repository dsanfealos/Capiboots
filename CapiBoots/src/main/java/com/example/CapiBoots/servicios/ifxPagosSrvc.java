package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Pagos;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;

public interface ifxPagosSrvc {

    public Pagos buscaId(Long id);
    List<Pagos> listaPagos();

}
