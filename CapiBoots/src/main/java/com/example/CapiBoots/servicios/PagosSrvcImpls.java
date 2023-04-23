package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Pagos;
import com.example.CapiBoots.repositorios.PagosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosSrvcImpls implements ifxPagosSrvc{

    @Autowired
    public PagosRepositorio pagorepo;


    @Override
    public Pagos buscaId(Long id) {
        return pagorepo.findById(id).orElse(null);
    }

    @Override
    public List<Pagos> listaPagos() {
        return pagorepo.findAll();
    }
}
