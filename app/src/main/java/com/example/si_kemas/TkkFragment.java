package com.example.si_kemas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.si_kemas.Adapter.TkkAdapter;
import com.example.si_kemas.Model.TkkModel;

import java.util.ArrayList;
import java.util.List;


public class TkkFragment extends Fragment {

    public View view;
    List<TkkModel> tkkList = new ArrayList<>();

    public TkkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tkk, container, false);

        buildData();
        setRecyclerView(view, tkkList);
        return view;
    }

    public void setRecyclerView(View view, List<TkkModel> tkkList ){

        RecyclerView recyclerView = view.findViewById(R.id.tkk_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        TkkAdapter adapter = new TkkAdapter(getActivity(), tkkList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void buildData(){
        tkkList.add(new TkkModel(1,"coba1",R.drawable.ic_image));
        tkkList.add(new TkkModel(2,"coba2",R.drawable.ic_favorit));
        tkkList.add(new TkkModel(1,"coba1",R.drawable.ic_image));
        tkkList.add(new TkkModel(2,"coba2",R.drawable.ic_favorit));
    }



}