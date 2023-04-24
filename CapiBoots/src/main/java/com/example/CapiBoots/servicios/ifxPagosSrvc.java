package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Pagos;
import com.example.CapiBoots.modelos.Usuario;

import java.util.List;
import java.util.Optional;

public interface ifxPagosSrvc {
    Optional<Pagos> buscaId(Long id);
    List<Pagos> ListaPagos();

public Pagos guardar(Pagos pago);
}
