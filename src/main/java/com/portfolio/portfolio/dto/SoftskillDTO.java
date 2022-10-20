package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SoftskillDTO {

    @NotNull
    @Size(max = 30000)
    private String description;

    //Constructores
    public SoftskillDTO() {
    }
    public SoftskillDTO(String description) {
        this.description = description;
    }

    //getter y setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
