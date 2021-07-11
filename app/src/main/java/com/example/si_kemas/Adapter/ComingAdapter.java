package com.example.si_kemas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Picasso.get().load("http://192.168.1.22:8080/Landingpage/img/"+url_img).into(holder.imgComing);
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
