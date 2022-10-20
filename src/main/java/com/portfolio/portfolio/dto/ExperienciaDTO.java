package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

public class ExperienciaDTO {
    @NotNull
    private String title;
    @NotNull
    private String time;
    @NotNull
    private String description;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String title, String time, String description) {
        this.title = title;
        this.time = time;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
