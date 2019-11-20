package com.example.homework4.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework4.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder>{

    ArrayList<Info> list;
    OnMyItemClickListener listener;

    public InfoAdapter(ArrayList<Info> list, OnMyItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_item,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Info info = list.get(position);
        holder.gmail.setText(info.getGmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView gmail;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            gmail = itemView.findViewById(R.id.txt_number);
            itemView.setOnClickListener(v->{
                listener.onMyItemClick(getAdapterPosition());
            });
        }
    }

    public interface OnMyItemClickListener{
        void onMyItemClick(int position);
    }
}
