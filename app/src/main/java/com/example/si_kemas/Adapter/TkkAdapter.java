package com.example.si_kemas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.si_kemas.Model.TkkModel;
import com.example.si_kemas.R;


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
        holder.imgTkk.setImageResource(tkkList.get(position).getImage());
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
