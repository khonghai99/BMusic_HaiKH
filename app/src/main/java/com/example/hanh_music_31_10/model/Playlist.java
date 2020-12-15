package com.example.hanh_music_31_10.model;

import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements RecyclerData {
    private int mIdCategory;
    private String mNameCategory;
    private List<Song> mSongList = new ArrayList<>();

    public Playlist(){
    }

    public Playlist(int mIdPlaylist, String mNamePlaylist) {
        this.mIdCategory = mIdPlaylist;
        this.mNameCategory = mNamePlaylist;
    }

    public Playlist(int mIdPlaylist, String mNamePlaylist, List<Song> mSongList) {
        this.mIdCategory = mIdPlaylist;
        this.mNameCategory = mNamePlaylist;
        this.mSongList = mSongList;
    }

    public List<Song> getSongList() {
        return mSongList;
    }

    public int getIdCategory() {
        return mIdCategory;
    }

    public String getNamePlaylist() {
        return mNameCategory;
    }

    public void setIdCategory(int mIdCategory) {
        this.mIdCategory = mIdCategory;
    }

    public void setNamePlaylist(String mNameCategory) {
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
