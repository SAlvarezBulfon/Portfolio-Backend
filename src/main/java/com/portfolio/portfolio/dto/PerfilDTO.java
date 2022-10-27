package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class PerfilDTO {

    @NotNull
    private String nombre;
    @NotNull
    private String puesto;

    //Constructores

//CONSTRUCTORES
    public PerfilDTO() {
    }

    public PerfilDTO( String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

//GETTERS Y SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
