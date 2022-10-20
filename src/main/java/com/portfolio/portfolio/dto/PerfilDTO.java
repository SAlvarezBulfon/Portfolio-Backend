package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class PerfilDTO {

    @NotNull
    @Size(max = 30000)
    private String photo_url;
    @NotNull
    private String nombre;
    @NotNull
    private String puesto;

    //Constructores

//CONSTRUCTORES
    public PerfilDTO() {
    }

    public PerfilDTO(String photo_url, String nombre, String puesto) {
        this.photo_url = photo_url;
        this.nombre = nombre;
        this.puesto = puesto;
    }

//GETTERS Y SETTERS
    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

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
