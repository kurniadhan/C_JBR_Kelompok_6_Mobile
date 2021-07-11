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
import com.example.si_kemas.Adapter.TifAdapter;
import com.example.si_kemas.Model.MifModel;
import com.example.si_kemas.Model.MifResponse;
import com.example.si_kemas.Model.TifResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MifFragment extends Fragment {

    public View view;
    List<MifModel> mifList = new ArrayList<>();
    RecyclerView recyclerView;
    public APIRequestKegiatan apiRequestKegiatan;
    public MifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mif, container, false);
        apiRequestKegiatan = APIUtils.getReqKegiatan();
        buildData();
        setRecyclerView(view);
        return view;
    }

    public void setRecyclerView(View view ){

        recyclerView = view.findViewById(R.id.mif_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }


    public void buildData(){
        Call<MifResponse> call = apiRequestKegiatan.getDataMif(2);
        call.enqueue(new Callback<MifResponse>() {
            @Override
            public void onResponse(Call<MifResponse> call, Response<MifResponse> response) {
                if (response.isSuccessful()){
                    String msg = response.body().getMessage();
                    mifList = response.body().getdataKegiatan();

                    MifAdapter adapter = new MifAdapter(getActivity(), mifList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    Toast.makeText(getActivity(), "Pesan: "+msg, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Gagal ambil all data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MifResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal konek server: "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }




}