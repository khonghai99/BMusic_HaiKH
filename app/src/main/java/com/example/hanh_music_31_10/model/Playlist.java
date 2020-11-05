package com.example.hanh_music_31_10.model;

import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements RecyclerData {
    private int mIdCategory;
    private String mNameCategory;
    private List<Song> mSongList = new ArrayList<>();

    public Playlist(int mIdCategory, String mNameCategory) {
        this.mIdCategory = mIdCategory;
        this.mNameCategory = mNameCategory;
    }

    public Playlist(int mIdCategory, String mNameCategory, List<Song> mSongList) {
        this.mIdCategory = mIdCategory;
        this.mNameCategory = mNameCategory;
        this.mSongList = mSongList;
    }

    public List<Song> getmSongList() {
        return mSongList;
    }

    public int getIdCategory() {
        return mIdCategory;
    }

    public String getNameCategory() {
        return mNameCategory;
    }

    public void setIdCategory(int mIdCategory) {
        this.mIdCategory = mIdCategory;
    }

    public void setNameCategory(String mNameCategory) {
        this.mNameCategory = mNameCategory;
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
