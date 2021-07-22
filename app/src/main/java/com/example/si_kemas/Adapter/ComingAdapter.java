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
import com.example.si_kemas.Model.ComingsoonModel;
import com.example.si_kemas.R;
import com.squareup.picasso.Picasso;


import java.util.List;


public class ComingAdapter extends RecyclerView.Adapter<ComingAdapter.ComingViewHolder> {

    Context context;
    List<ComingsoonModel> comingList;

    public ComingAdapter(Context context, List<ComingsoonModel> comingList){
        this.context = context;
        this.comingList = comingList;
    }



    @NonNull
    @Override
    public ComingViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_comingsoon, parent, false);
        return new ComingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ComingAdapter.ComingViewHolder holder, int position) {
//        holder.imgComing.setImageResource(comingList.get(position).getNama_foto());
        String url_img = comingList.get(position).getNama_foto();
        Picasso.get().load("http://192.168.1.21:8000/Landingpage/img/"+url_img).into(holder.imgComing);
        holder.imgComing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailKegiatan.class);
                i.putExtra("id_kegiatan", comingList.get(position).getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comingList.size();
    }

    public static class ComingViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgComing;

        public ComingViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgComing = itemView.findViewById(R.id.comingsoon_img);
        }
    }
}
