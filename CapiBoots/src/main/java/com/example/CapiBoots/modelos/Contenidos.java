package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Contenidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contenidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="nombre", columnDefinition = "VARCHAR(225)")
    private String nombre;
    //@ManyToOne
    //@JoinColumn(name="idserie", nullable = false)
    private Long idserie;
    //@ManyToOne
    //@JoinColumn(name="idtemporada", nullable = false)
    private Long idtemporada;
    @Column(name="FechaAlta")
    private Date fechaAlta;






}
