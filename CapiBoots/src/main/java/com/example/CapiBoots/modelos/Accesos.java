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

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;

//    @ManyToOne
//    @JoinColumn(name = "idContenido", nullable = false)
    private Long idContenido;

    @Column(name = "fin")
    private LocalDateTime fin;

}
