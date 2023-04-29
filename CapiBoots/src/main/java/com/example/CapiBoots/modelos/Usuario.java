package com.example.CapiBoots.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaAlta")
    private LocalDate fechaAlta;

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

    @ManyToMany // Many to Many entre Usuarios y Logros
    @JoinTable(
            name = "usuarios_logros",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_logro"))
    private List<Logro> logros;

    @ManyToMany // Many to Many entre Usuarios y Logros
    @JoinTable(
            name = "seguimientos",
            joinColumns = @JoinColumn(name = "id_seguidor"),
            inverseJoinColumns = @JoinColumn(name = "id_seguido"))


    private List<Usuario> seguidos;

    //Crear Many to Many de seguidos y seguidores
    @ManyToMany(mappedBy = "seguidos")
    private List<Usuario> seguidores;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="usuarios_roles",
            joinColumns={@JoinColumn(name="USUARIO_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROL_ID", referencedColumnName="ID")})
    private List<Rol> roles = new ArrayList<>();
}

