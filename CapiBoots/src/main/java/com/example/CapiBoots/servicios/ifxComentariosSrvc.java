package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Comentarios;

import java.util.List;

public interface ifxComentariosSrvc {
        public Comentarios buscaId(Long id);
        List<Comentarios> listaCom();

}
