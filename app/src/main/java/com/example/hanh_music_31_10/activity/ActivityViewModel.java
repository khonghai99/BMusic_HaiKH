package com.example.hanh_music_31_10.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hanh_music_31_10.model.PlaySong;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;

public class ActivityViewModel extends ViewModel {

    private final MutableLiveData<Playlist> mDetailPlaylist = new MutableLiveData<>();
    private final MutableLiveData<PlaySong> mPlaySong = new MutableLiveData<>();
    // nhan su kien khi click vao mot bai hat
    private final MutableLiveData<Song> mClickSong = new MutableLiveData<>();

    public ActivityViewModel() {
    }

    public MutableLiveData<Playlist> getDetailPlayList() {
        return mDetailPlaylist;
    }

    public void setDetailPlaylist(Playlist mPLayList) {
        this.mDetailPlaylist.setValue(mPLayList);
    }
    //
    public MutableLiveData<PlaySong> getPlaylist() {
        return mPlaySong;
    }

    public void setPlaylist(PlaySong mPlaylist) {
        this.mPlaySong.setValue(mPlaylist);
    }

}
