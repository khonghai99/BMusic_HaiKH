package com.example.hanh_music_31_10.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hanh_music_31_10.model.PlaySong;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;

public class LibraryViewModel extends ViewModel {

    private final MutableLiveData<Playlist> mDetailPlaylist = new MutableLiveData<>();
    private final MutableLiveData<Song> mPlaySong = new MutableLiveData<>();
    // nhan su kien khi click vao mot bai hat
    private final MutableLiveData<Song> mClickSong = new MutableLiveData<>();

    private String mCurrentRef;

    private final MutableLiveData<Playlist> mPlaylistFirstClick = new MutableLiveData<>();

    public LibraryViewModel() {
    }

    public MutableLiveData<Playlist> getDetailPlayList() {
        return mDetailPlaylist;
    }

    public void setDetailPlaylist(Playlist mPLayList) {
        this.mDetailPlaylist.setValue(mPLayList);
    }
//
    public MutableLiveData<Song> getPlaySong() {
        return mPlaySong;
    }

    public void setPlaySong(Song song) {
        this.mPlaySong.setValue(song);
    }

    public MutableLiveData<Playlist> openDetailPlaylist(){
        return mPlaylistFirstClick;
    }
    public void setPlaylistFirstClick( Playlist playlist){
        this.mPlaylistFirstClick.setValue(playlist);
    }

    public String getCurrentRef() {
        return mCurrentRef;
    }

    public void setCurrentRef(String mCurrentRef) {
        this.mCurrentRef = mCurrentRef;
    }
}