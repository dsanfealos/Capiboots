package com.example.CapiBoots.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//Para crear 2 id en la misma tabla
@Embeddable
public class IdsUsuarios implements Serializable {

    //Preguntar para hacer id autoincremental (¿Usar id++?)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    public IdsUsuarios() {
    }

    public IdsUsuarios(Long id, String nombre_usuario) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
    }

    public Long getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdsUsuarios)) return false;
        IdsUsuarios that = (IdsUsuarios) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNombre_usuario(), that.getNombre_usuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre_usuario());
    }
}
