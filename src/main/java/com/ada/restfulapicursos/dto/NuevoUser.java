package com.ada.restfulapicursos.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class NuevoUser {
	
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String pw;

    private Set<String> roles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombreUsuario(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return pw;
    }

    public void setPassword(String password) {
        this.pw = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
