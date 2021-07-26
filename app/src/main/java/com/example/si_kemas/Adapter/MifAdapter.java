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
import com.example.si_kemas.Model.MifModel;
import com.example.si_kemas.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MifAdapter extends RecyclerView.Adapter<MifAdapter.MifViewHolder> {

    Context context;
    List<MifModel> mifList;

    public MifAdapter(Context context, List<MifModel> mifList){
        this.context = context;
        this.mifList = mifList;
    }



    @NonNull
    @Override
    public MifViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item_mif, parent, false);
        return new MifViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MifAdapter.MifViewHolder holder, int position) {
        String url_img = mifList.get(position).getNama_foto();
        Picasso.get().load("http://192.168.239.59:8000/frontend/img/"+url_img).into(holder.imgMif);
        holder.imgMif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailKegiatan.class);
                i.putExtra("id_kegiatan", mifList.get(position).getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mifList.size();
    }

    public static class MifViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgMif;

        public MifViewHolder(@NonNull  View itemView) {
            super(itemView);
            imgMif = itemView.findViewById(R.id.mif_img);
        }
    }
}
