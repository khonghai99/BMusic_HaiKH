package com.example.hanh_music_31_10.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Song> mDetailSong = new MutableLiveData<>();
    private MutableLiveData<List<Playlist>> mPlaylist = new MutableLiveData<>();

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Song> getDetailSong() {
        return mDetailSong;
    }

    public void setDetailSong(Song mSong) {
        this.mDetailSong.setValue(mSong);
    }

    public MutableLiveData<List<Playlist>> getPlaylist() {
        return mPlaylist;
    }

    public void setPlaylist(List<Playlist> mPlaylist) {
        this.mPlaylist.setValue(mPlaylist);
    }
}