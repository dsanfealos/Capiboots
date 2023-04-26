package com.example.CapiBoots.servicios;

import com.example.CapiBoots.modelos.Comentarios;
import com.example.CapiBoots.modelos.Contenidos;

import java.util.List;
import java.util.Optional;

public interface ifxComentariosSrvc {

        Optional<Contenidos> buscarComentario(Long id);
        public Contenidos guardarComentario();
        public Contenidos  eliminarComentario();
        public Contenidos actualizarComentario();
        public Contenidos  buscarComentario();

        Optional<Comentarios> buscarComentarioId(Long id);

       Optional <Comentarios> buscaId(Long id);

        List<Comentarios> listaCom();

        public Contenidos guardar(Contenidos contenido);

        //Guardar
        Comentarios guardar(Comentarios comentario);
}
