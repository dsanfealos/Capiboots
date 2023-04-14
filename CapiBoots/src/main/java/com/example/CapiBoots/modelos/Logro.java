package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="logros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Logro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false,columnDefinition = "VARCHAR(200)")
    private String descripcion;
   // @ManyToOne
    //@JoinColumn(name = "idcontenido", nullable = false)
    private long idContenido;

    @Column(name = "tipologro", nullable = false)
    private String tipoLogro;

    @Column(name = "minimo", nullable = false)
    private int minimo;
}
