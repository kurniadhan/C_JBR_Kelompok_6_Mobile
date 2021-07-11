package com.example.si_kemas.Model;

public class TkkModel {
    private Integer id;
    private String judul;
    private Integer image;

    public TkkModel(Integer id, String judul, Integer image) {
        this.id = id;
        this.judul = judul;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
