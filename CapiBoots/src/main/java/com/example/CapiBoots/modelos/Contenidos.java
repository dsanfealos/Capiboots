package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @Column(name="descripcion", columnDefinition = "VARCHAR(225)")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="idserie", nullable = true)
    private Series idserie;
    @ManyToOne
    @JoinColumn(name="idtemporada", nullable = true)
    private Temporada idtemporada;
    @Column(name="FechaAlta", columnDefinition = "DATETIME")
    private Date fechaAlta;
    @Column(name = "Novedad", columnDefinition = "tinyint(1) default 1")
    private Boolean novedad;

    @Column(name="imagen_logo", columnDefinition = "VARCHAR(225)")
    private String imagenLogo;

    @Column(name="imagen_fondo", columnDefinition = "VARCHAR(225)")
    private String imagenFondo;

    @Column(name="ruta_video", columnDefinition = "VARCHAR(225)")
    private String rutaVideo;

    @ManyToMany // Many to Many entre Contenidos y Categorias
    @JoinTable(
            name = "contenidos_categorias",
            joinColumns = @JoinColumn(name = "id_contenido"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categorias> categorias;


    @OneToMany(mappedBy = "contenido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Accesos> accesos;




}
