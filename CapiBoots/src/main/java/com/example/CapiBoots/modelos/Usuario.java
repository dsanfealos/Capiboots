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

    @EmbeddedId
    @GeneratedValue
    private IdsUsuarios id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String clave;

    private Date fechaAlta;


    private Integer edad;

    private Byte genero;

    @Column(columnDefinition = "VARCHAR(60)")
    private String correo;

    private String pais;

    @Column(columnDefinition = "VARCHAR(225)")
    private String avatar;

    private Long amigo;

    private Boolean borrar_amigo;

    private Boolean suscripcion;

    private Boolean cancelar_suscripcion;

    private Boolean control_parental;

    private Boolean editar_perfil;

    @Column(columnDefinition = "VARCHAR(225)")
    private String soporte;
}

