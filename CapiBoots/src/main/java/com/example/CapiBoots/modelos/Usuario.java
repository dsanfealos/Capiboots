package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_usuario", unique = true, nullable = false)
    private String nombre_usuario;

    @Column(name = "clave", columnDefinition = "VARCHAR(100)")
    private String clave;

    @Column(name = "fechaAlta")
    private Date fechaAlta;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "genero")
    private Byte genero;

    @Column(name = "correo", columnDefinition = "VARCHAR(60)")
    private String correo;

    @Column(name = "pais")
    private String pais;

    @Column(name = "avatar", columnDefinition = "VARCHAR(225)")
    private String avatar;

    @Column(name = "amigo")
    private Long amigo;

    @Column(name = "borrar_amigo")
    private Boolean borrar_amigo;

    @Column(name = "suscripcion")
    private Boolean suscripcion;

    @Column(name = "cancelar_suscripcion")
    private Boolean cancelar_suscripcion;

    @Column(name = "control_parental")
    private Boolean control_parental;

    @Column(name = "editar_perfil")
    private Boolean editar_perfil;

    @Column(name = "soporte", columnDefinition = "VARCHAR(225)")
    private String soporte;
}
