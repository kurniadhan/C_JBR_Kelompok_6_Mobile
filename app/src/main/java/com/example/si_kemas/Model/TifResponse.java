package com.example.si_kemas.Model;

import java.util.List;

public class TifResponse {
    private String message;
    private List<TifModel> dataKegiatan;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TifModel> getdataKegiatan() {
        return dataKegiatan;
    }

    public void setdataKegiatan(List<TifModel> dataKegiatan) {
        this.dataKegiatan = dataKegiatan;
    }
}
