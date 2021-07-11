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
import com.example.si_kemas.Model.ComingsoonModel;
import com.example.si_kemas.Model.ComingsoonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ComingsoonFragment extends Fragment {

    APIRequestKegiatan apiRequestKegiatan;
    public View view;
    List<ComingsoonModel> comingList = new ArrayList<>();
    RecyclerView recyclerView;

    public ComingsoonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_comingsoon, container, false);
        apiRequestKegiatan = APIUtils.getReqKegiatan();

        buildData();
        setRecyclerView(view);
        return view;
    }

    public void setRecyclerView(View view ){

        recyclerView = view.findViewById(R.id.comingsoon_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    public void buildData(){
        Call<ComingsoonResponse> call = apiRequestKegiatan.getKegiatan();
        call.enqueue(new Callback<ComingsoonResponse>() {
            @Override
            public void onResponse(Call<ComingsoonResponse> call, Response<ComingsoonResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    comingList = response.body().getKegiatan();

                    ComingAdapter adapter = new ComingAdapter(getActivity(), comingList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(), "Pesan: "+msg, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Gagal ambil all data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ComingsoonResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



}