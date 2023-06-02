package com.example.CapiBoots.servicios.util;

import com.example.CapiBoots.modelos.Usuario;
import org.apache.commons.lang3.builder.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * The type Custom user details.
 */
public class CustomUserDetails extends Usuario implements UserDetails {

    private String username;
    private String password;

    private String email;

    private Byte gender;

    private Integer age;

    private String country;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Instantiates a new Custom user details.
     *
     * @param username    the username
     * @param password    the password
     * @param authorities the authorities
     */
    //Creamos un constructor de un UserDetails con nuestros parámetros de Usuario necesarios
    //Los parámetros seleccionados se pueden conseguir del usuario que ha iniciado sesión
    public CustomUserDetails(String username, String password, String email, Byte gender, Integer age, String country, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.authorities = authorities;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public String getUsername() {
        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}
