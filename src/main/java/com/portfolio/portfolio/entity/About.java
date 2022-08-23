package com.portfolio.portfolio.entity;

import javax.persistence.*;
// Genera la entidad en la BD
@Entity
// Este es el nombre que recibirá en la BD.
@Table(name = "about")
public class About {
    @Id
    // Lo hace autoincremental
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String description1;
    private String description2;
    private String url_CV;

    //-- CONSTRUCTORES --

    public About() {
    }

    public About(int id, String description1, String description2, String url_CV) {
        this.id = id;
        this.description1 = description1;
        this.description2 = description2;
        this.url_CV = url_CV;
    }

    // -- GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getUrl_CV() {
        return url_CV;
    }

    public void setUrl_CV(String url_CV) {
        this.url_CV = url_CV;
    }
}
