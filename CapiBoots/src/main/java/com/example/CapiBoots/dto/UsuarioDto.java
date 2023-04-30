package com.example.CapiBoots.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;

    @NotEmpty(message = "Es necesario escribir el nombre de usuario")
    private String nombre_usuario;

    @NotEmpty
    private String clave;

    private Integer edad;

    private Byte genero;

    @NotEmpty(message = "Es necesario escribir el correo electrónico")
    @Email
    private String correo;

    private String pais;

}
