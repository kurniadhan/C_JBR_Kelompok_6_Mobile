package com.example.si_kemas.Model;

import java.util.List;

public class DetailResponse {
    private String message;
    private List<DetailModel> detailKegiatan;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DetailModel> getDetailKegiatan() {
        return detailKegiatan;
    }

    public void setDetailKegiatan(List<DetailModel> detailKegiatan) {
        this.detailKegiatan = detailKegiatan;
    }
}
