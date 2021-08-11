package com.company;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Conserje.class, name = "com.company.Conserje"),
        @JsonSubTypes.Type(value = Pasajero.class, name = "com.company.Pasajero"),
        @JsonSubTypes.Type(value = Administrador.class, name = "com.company.Administrador")
})

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String dni;
    private String usuario;
    private String constrasena;

    private boolean activo = true;

    public Usuario() {
    }


    public Usuario(String nombre, String apellido, String dni, String usuario, String constrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.constrasena = constrasena;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Nombre..........." + nombre + "\n" +
                "Apellido........." + apellido + "\n" +
                "Dni.............." + dni + "\n" +
                "Usuario.........." + usuario + "\n" +
                "Constrasena......" + constrasena + "\n";
    }
}
