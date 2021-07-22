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
import com.example.si_kemas.Model.TkkModel;
import com.example.si_kemas.R;
import com.squareup.picasso.Picasso;


import java.util.List;


public class TkkAdapter extends RecyclerView.Adapter<TkkAdapter.TkkViewHolder> {

    Context context;
    List<TkkModel> tkkList;

    public TkkAdapter(Context context, List<TkkModel> tkkList){
        this.context = context;
        this.tkkList = tkkList;
    }



    @NonNull
    @Override
    public TkkViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_tkk, parent, false);
        return new TkkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TkkAdapter.TkkViewHolder holder, int position) {
        String url_img = tkkList.get(position).getNama_foto();
        Picasso.get().load("http://192.168.1.21:8000/Landingpage/img/"+url_img).into(holder.imgTkk);
        holder.imgTkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailKegiatan.class);
                i.putExtra("id_kegiatan", tkkList.get(position).getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tkkList.size();
    }

    public static class TkkViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgTkk;

        public TkkViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgTkk = itemView.findViewById(R.id.tkk_img);
        }
    }
}
