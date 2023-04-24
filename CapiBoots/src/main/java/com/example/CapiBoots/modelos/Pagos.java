package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPagador", nullable = true)
    private Usuario idPagador;

    private Float importe;

    @ManyToOne
    @JoinColumn(name = "idMedio", nullable = true)
    private Medio medio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha")
    private LocalDate fecha;
}
