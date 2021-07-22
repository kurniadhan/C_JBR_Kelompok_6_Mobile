package com.example.si_kemas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.si_kemas.DetailKegiatan;
import com.example.si_kemas.Model.TifModel;
import com.example.si_kemas.R;
import com.squareup.picasso.Picasso;


import java.util.List;


public class TifAdapter extends RecyclerView.Adapter<TifAdapter.TifViewHolder> {

    Context context;
    List<TifModel> tifList;

    public TifAdapter(Context context, List<TifModel> tifList){
        this.context = context;
        this.tifList = tifList;
    }

    @NonNull
    @Override
    public TifViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_tif, parent, false);
        return new TifViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TifAdapter.TifViewHolder holder, int position) {
        String url_img = tifList.get(position).getNama_foto();
        Picasso.get().load("http://192.168.1.21:8000/Landingpage/img/"+url_img).into(holder.imgTif);
        holder.imgTif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailKegiatan.class);
                i.putExtra("id_kegiatan", tifList.get(position).getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tifList.size();
    }

    public static class TifViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgTif;

        public TifViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgTif = itemView.findViewById(R.id.tif_img);
        }
    }
}
