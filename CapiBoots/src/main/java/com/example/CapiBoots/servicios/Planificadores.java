package com.example.CapiBoots.servicios;

import com.example.CapiBoots.repositorios.ContenidosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Planificadores {
    @Autowired
    public ContenidosRepositorio conRepo;

    //Para volver novedades = false tras 7 días
    @Scheduled   // falta indicar la planificación. Consultar la librería awaitility
    public void quitaNovedades(){
        conRepo.quitaNovedades();
    }
}
