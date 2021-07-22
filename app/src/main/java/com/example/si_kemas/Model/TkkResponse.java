package com.example.si_kemas.Model;

import java.util.List;

public class TkkResponse {
    private String message;
    private List<TkkModel> dataKegiatan;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TkkModel> getdataKegiatan() {
        return dataKegiatan;
    }

    public void setdataKegiatan(List<TkkModel> dataKegiatan) { this.dataKegiatan = dataKegiatan;
    }
}
