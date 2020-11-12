package com.example.hanh_music_31_10.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

public class ImageSearchModel implements RecyclerData {
    private int mId;
    private int mImageSearchUrl;

    public ImageSearchModel(int mId, int mImageSearchUrl) {
        this.mId = mId;
        this.mImageSearchUrl = mImageSearchUrl;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getImageSearchUrl() {
        return mImageSearchUrl;
    }

    public void setImageSearchUrl(int mImageSearchUrl) {
        this.mImageSearchUrl = mImageSearchUrl;
    }

    //lay anh theo bitmap neu co path
    public Bitmap loadImageFromPath(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] data = mediaMetadataRetriever.getEmbeddedPicture();
        return data == null ? null : BitmapFactory.decodeByteArray(data, 0, data.length);
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(RecyclerData other) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(RecyclerData other) {
        return false;
    }
}
