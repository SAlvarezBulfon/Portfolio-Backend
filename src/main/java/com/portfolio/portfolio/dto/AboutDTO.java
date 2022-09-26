package com.portfolio.portfolio.dto;

import com.sun.istack.NotNull;

public class AboutDTO {
    @NotNull
    private String description1;
    @NotNull
    private String description2;
    @NotNull
    private String url_CV;

    //Constructores
    public AboutDTO() {}

    public AboutDTO(String description1, String description2, String url_CV) {
        this.description1 = description1;
        this.description2 = description2;
        this.url_CV = url_CV;
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
