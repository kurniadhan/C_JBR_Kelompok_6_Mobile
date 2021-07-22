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
import com.example.si_kemas.Adapter.MifAdapter;
import com.example.si_kemas.Adapter.TkkAdapter;
import com.example.si_kemas.Model.MifResponse;
import com.example.si_kemas.Model.TkkModel;
import com.example.si_kemas.Model.TkkResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TkkFragment extends Fragment {

    public View view;
    List<TkkModel> tkkList = new ArrayList<>();
    RecyclerView recyclerView;
    public APIRequestKegiatan apiRequestKegiatan;
    public TkkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tkk, container, false);
        apiRequestKegiatan = APIUtils.getReqKegiatan();
        buildData();
        setRecyclerView(view);
        return view;
    }

    public void setRecyclerView(View view ){

        recyclerView = view.findViewById(R.id.tkk_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    public void buildData(){
        Call<TkkResponse> call = apiRequestKegiatan.getDataTkk(3);
        call.enqueue(new Callback<TkkResponse>() {
            @Override
            public void onResponse(Call<TkkResponse> call, Response<TkkResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    tkkList = response.body().getdataKegiatan();

                    TkkAdapter adapter = new TkkAdapter(getActivity(), tkkList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(), "Pesan: "+msg, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Gagal ambil all data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TkkResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}



