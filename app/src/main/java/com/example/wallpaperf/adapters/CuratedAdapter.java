package com.example.wallpaperf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaperf.R;
import com.example.wallpaperf.listeners.OnRecyclerClickListener;
import com.example.wallpaperf.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CuratedAdapter extends RecyclerView.Adapter<CuratedViewHolder>{

    Context context;
    ArrayList<Photo> list;
    OnRecyclerClickListener listener;

    public CuratedAdapter(Context context, ArrayList<Photo> list, OnRecyclerClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CuratedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CuratedViewHolder(LayoutInflater.from(context).inflate(R.layout.home_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CuratedViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getSrc().getLarge2x()).placeholder(R.drawable.placeholder).into(holder.imageView_list);

        holder.home_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


 class CuratedViewHolder extends RecyclerView.ViewHolder{

    CardView home_list_container;
    ImageView imageView_list;

     public CuratedViewHolder(@NonNull View itemView) {
         super(itemView);
         home_list_container = itemView.findViewById(R.id.home_list_container);
         imageView_list = itemView.findViewById(R.id.imageView_list);
     }
 }