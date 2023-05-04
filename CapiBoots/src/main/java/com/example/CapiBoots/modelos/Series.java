package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Series")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="nombre",columnDefinition = "VARCHAR(45)")
    private String nombre;

    @Column(name= "descripcion",columnDefinition = "VARCHAR(225)")
    private String descripcion;

    @OneToMany(mappedBy = "idserie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contenidos> contenidos;

    @OneToMany(mappedBy = "serie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Temporada> temporadas;
}