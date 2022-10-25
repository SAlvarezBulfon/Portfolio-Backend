package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

public class HardskillsDTO {
    @NotNull
    private String nombre;
    @NotNull
    private int porcentaje;

    public HardskillsDTO() {
    }

    public HardskillsDTO(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
