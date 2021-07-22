package com.example.si_kemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.si_kemas.API.APIRequestKegiatan;
import com.example.si_kemas.API.APIUtils;
import com.example.si_kemas.Model.DetailModel;
import com.example.si_kemas.Model.DetailResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailKegiatan extends AppCompatActivity {
    private Integer id_kegiatan;
    private APIRequestKegiatan apiRequestKegiatan;
    private TextView dtJudulKegiatan,  dtProdi, dtPemateri, dtDeskripsi, dtBukaRegistrasi,
            dtTglPelaksaan, dtJamMulai, dtJamSelesai, dtCp;
    private Button dtLinkMeet;
    private ImageView dtFoto,dtBack;

    private List<DetailModel> dataDetail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailkegiatan);
        apiRequestKegiatan = APIUtils.getReqKegiatan();
        id_kegiatan = getIntent().getIntExtra("id_kegiatan", 0);
        cariView();
        ambilData(id_kegiatan);


    }

    private void setView(){
        List<DetailModel> item = dataDetail;
        String url_img = item.get(0).getNama_foto();
        Picasso.get().load("http://192.168.1.21:8000/Landingpage/img/"+url_img).into(dtFoto);
        dtJudulKegiatan.setText(item.get(0).getJudul_kegiatan());
        dtProdi.setText(item.get(0).getProdi());
        dtPemateri.setText(item.get(0).getNama_pemateri());
        dtDeskripsi.setText(item.get(0).getDeskripsi());
        dtBukaRegistrasi.setText(item.get(0).getBuka_registrasi());
        dtTglPelaksaan.setText(item.get(0).getTgl_pelaksaan());
        dtTglPelaksaan.setText(item.get(0).getTgl_pelaksaan());
        dtTglPelaksaan.setText(item.get(0).getTgl_pelaksaan());
        dtJamMulai.setText(item.get(0).getJam_mulai());
        dtJamSelesai.setText(item.get(0).getJam_selesai());
        dtCp.setText(item.get(0).getContact_person());
        dtLinkMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse(item.get(0).getLink_meet()));
                startActivity(i);
            }
        });
        dtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void ambilData(Integer id){
        Call<DetailResponse> call = apiRequestKegiatan.getDetail(id);
        call.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                if(response.isSuccessful()){
                    String message = response.body().getMessage();
                    dataDetail = response.body().getDetailKegiatan();
                    setView();
                    Toast.makeText(getBaseContext(),message, Toast.LENGTH_SHORT);
                }else {
                    Toast.makeText(getBaseContext(),"Gagal ambil data", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_SHORT);
            }
        });

    }

    private void cariView(){
        dtBack = findViewById(R.id.dt_back);
        dtJudulKegiatan = findViewById(R.id.dt_judulkegiatan);
        dtFoto = findViewById(R.id.dt_foto);
        dtProdi = findViewById(R.id.dt_prodi);
        dtPemateri = findViewById(R.id.dt_pemateri);
        dtDeskripsi = findViewById(R.id.dt_deskripsi);
        dtBukaRegistrasi = findViewById(R.id.dt_bukaregistrasi);
        dtTglPelaksaan = findViewById(R.id.dt_tglpelaksanaan);
        dtJamMulai = findViewById(R.id.dt_jammulai);
        dtJamSelesai = findViewById(R.id.dt_jamselesai);
        dtCp = findViewById(R.id.dt_cp);
        dtLinkMeet = findViewById(R.id.link_meet);

    }

}