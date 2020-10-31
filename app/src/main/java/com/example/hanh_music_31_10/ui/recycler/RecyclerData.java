package com.example.hanh_music_31_10.ui.recycler;

public interface RecyclerData {

    @RecyclerViewType
    int getViewType();
    boolean areItemsTheSame(RecyclerData other);
    boolean areContentsTheSame(RecyclerData other);
}
