package com.example.si_kemas.API;

import com.example.si_kemas.Model.ComingsoonResponse;
import com.example.si_kemas.Model.DetailResponse;
import com.example.si_kemas.Model.MifResponse;
import com.example.si_kemas.Model.TifResponse;
import com.example.si_kemas.Model.TkkResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRequestKegiatan {

    @GET("api/kegiatan")
    Call<ComingsoonResponse> getKegiatan();

    @GET("api/kegiatan/{id}")
    Call<TifResponse> getDataTif(@Path("id") int id);

    @GET("api/kegiatan/{id}")
    Call<MifResponse> getDataMif(@Path("id") int id);

    @GET("api/kegiatan/{id}")
    Call<TkkResponse> getDataTkk(@Path("id") int id);

    @GET("api/kegiatan/{id}/detail")
    Call<DetailResponse> getDetail(@Path("id") int id);


}
