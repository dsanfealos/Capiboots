package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="accesos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accesos{

    @Id
    @Column(name = "id", nullable = false)
    @Convert(converter = TimeConverter.class)
    protected LocalDateTime fecha;

    private Long idUsuario;

    private Long idContenido;

    private LocalDateTime fin;

}
