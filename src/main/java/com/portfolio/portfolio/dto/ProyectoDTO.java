package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

import javax.persistence.Column;
public class ProyectoDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;

    //Marcamos la cantidad máxima de caracteres que se pueden ingresar
    @Column(length = 2048)
    @NotNull
    private String url_image;

    @Column(length = 2048)
    @NotNull
    private String url_sourceCode;

     //CONSTRUCTOR
    public ProyectoDTO() {
    }

    public ProyectoDTO(String name, String description, String url_image, String url_sourceCode) {
        this.name = name;
        this.description = description;
        this.url_image = url_image;
        this.url_sourceCode = url_sourceCode;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getUrl_sourceCode() {
        return url_sourceCode;
    }

    public void setUrl_sourceCode(String url_sourceCode) {
        this.url_sourceCode = url_sourceCode;
    }
}
