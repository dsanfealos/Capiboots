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
    private String name;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Instantiates a new Custom user details.
     *
     * @param username    the username
     * @param password    the password
     * @param name        the name
     * @param authorities the authorities
     */
    public CustomUserDetails(String username, String password, String name, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.name = name;
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
        return false;
    }


    @Override
    public boolean isAccountNonLocked() {
        return false;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }


    @Override
    public boolean isEnabled() {
        return false;
    }
}
