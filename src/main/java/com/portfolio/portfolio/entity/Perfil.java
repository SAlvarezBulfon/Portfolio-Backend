package com.portfolio.portfolio.entity;

import javax.persistence.*;

// Genera la entidad en la BD
@Entity
// Este es el nombre que recibirá en la BD.
@Table(name = "perfil")
public class Perfil {
    @Id
    // Lo hace autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photo_url;
    private String nombre;
    private String puesto;

    //-- CONSTRUCTORES --

    public Perfil() {
    }

    public Perfil(String photo_url, String nombre, String puesto) {
        this.id = id;
        this.photo_url = photo_url;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    // -- GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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