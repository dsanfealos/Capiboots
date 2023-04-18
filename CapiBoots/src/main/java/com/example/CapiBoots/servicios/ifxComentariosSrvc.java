package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Comentarios;

import java.util.List;

public interface ifxComentariosSrvc {
        public Comentarios buscaNombre(String nombre);
        List<Comentarios> listaCom();

}
