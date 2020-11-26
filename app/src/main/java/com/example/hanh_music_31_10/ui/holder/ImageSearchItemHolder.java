package com.example.hanh_music_31_10.ui.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.ImageSearchModel;
import com.example.hanh_music_31_10.service.MediaPlaybackService;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class ImageSearchItemHolder extends BaseRecyclerViewHolder {

    private ImageButton mImageSearchButton;

    public ImageSearchItemHolder(@NonNull View itemView) {
        super(itemView);
        mImageSearchButton = itemView.findViewById(R.id.image_search);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
//        if (data instanceof ImageSearchModel)
//            mImageSearchButton.setImageResource(((ImageSearchModel) data).getImageSearchUrl());
        //load anh
    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {
    }

    @Override
    public void setService(MediaPlaybackService service) {

    }
}
