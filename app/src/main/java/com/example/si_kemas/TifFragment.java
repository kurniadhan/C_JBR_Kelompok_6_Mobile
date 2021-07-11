package com.example.si_kemas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.si_kemas.API.APIRequestKegiatan;
import com.example.si_kemas.API.APIUtils;
import com.example.si_kemas.Adapter.ComingAdapter;
import com.example.si_kemas.Adapter.TifAdapter;
import com.example.si_kemas.Model.TifResponse;
import com.example.si_kemas.Model.TifModel;
import com.example.si_kemas.Model.TifResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TifFragment extends Fragment {

    public View view;
    List<TifModel> tifList = new ArrayList<>();
    RecyclerView recyclerView;
    public APIRequestKegiatan apiRequestKegiatan;

    public TifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tif, container, false);
        apiRequestKegiatan = APIUtils.getReqKegiatan();
        buildData();
        setRecyclerView(view);
        return view;
    }

    public void setRecyclerView(View view ){

        recyclerView = view.findViewById(R.id.tif_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    public void buildData(){
        Call<TifResponse> call = apiRequestKegiatan.getDataTif(1);
        call.enqueue(new Callback<TifResponse>() {
            @Override
            public void onResponse(Call<TifResponse> call, Response<TifResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    tifList = response.body().getdataKegiatan();

                    TifAdapter adapter = new TifAdapter(getActivity(), tifList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(), "Pesan: "+msg, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Gagal ambil all data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TifResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



}