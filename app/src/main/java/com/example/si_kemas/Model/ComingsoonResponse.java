package com.example.si_kemas.Model;

import java.util.List;

public class ComingsoonResponse {
    private String message;
    private List<ComingsoonModel> kegiatan;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ComingsoonModel> getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(List<ComingsoonModel> kegiatan) {
        this.kegiatan = kegiatan;
    }
}
