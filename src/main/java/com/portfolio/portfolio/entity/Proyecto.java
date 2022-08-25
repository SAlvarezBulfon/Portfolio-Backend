package com.portfolio.portfolio.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

// Genera la entidad en la Base de Datos
@Entity
// Nombre que tendrá nuestra tabla en la base de datos
@Table(name = "proyecto")
public class Proyecto {
    //Id.
    @Id
    // Hace el id autoincremental
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String url_image;
    private String url_sourceCode;

    // Constructor vacío
    public Proyecto(){}

    // Constructor
    public Proyecto(String name, String description, String url_image, String url_sourceCode){
        this.name = name;
        this.description = description;
        this.url_image = url_image;
        this.url_sourceCode = url_sourceCode;
    }
    /*
       <========================================
                 SETTERS Y GETTERS
       ========================================>
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
