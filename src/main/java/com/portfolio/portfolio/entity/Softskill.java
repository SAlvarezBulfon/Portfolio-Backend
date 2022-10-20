package com.portfolio.portfolio.entity;


import javax.persistence.*;

@Entity
@Table(name = "softSkills")
public class Softskill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;


    public Softskill() {
    }

    public Softskill(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
