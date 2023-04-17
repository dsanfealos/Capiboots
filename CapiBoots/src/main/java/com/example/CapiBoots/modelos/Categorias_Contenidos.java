package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Categorías de contenidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorias_Contenidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JoinColumn(name = "Categoría", nullable = false)
    //@ManyToOne
    private Long categoria;
    //@JoinColumn(name = "Contenido", nullable = false)
    //@ManyToOne
    private Long contenido;

}
