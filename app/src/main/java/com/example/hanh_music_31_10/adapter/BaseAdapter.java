package com.example.hanh_music_31_10.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaseAdapter<T extends RecyclerView.ViewHolder>  extends RecyclerView.Adapter<T>  {
    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
