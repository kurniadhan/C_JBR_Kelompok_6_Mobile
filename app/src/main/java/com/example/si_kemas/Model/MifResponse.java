package com.example.si_kemas.Model;

import java.util.List;

public class MifResponse {
    private String message;
    private List<MifModel> dataKegiatan;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MifModel> getdataKegiatan() {
        return dataKegiatan;
    }

    public void setdataKegiatan(List<MifModel> dataKegiatan) {
        this.dataKegiatan = dataKegiatan;
    }
}
