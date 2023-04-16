package com.example.CapiBoots.modelos;

import jakarta.persistence.*;

public class Usuario_has_Logros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "logros_id")
    private Logro logro;
}