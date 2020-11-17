package com.example.hanh_music_31_10.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;

import java.util.List;

public class LibraryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private final MutableLiveData<Playlist> mDetailPlaylist = new MutableLiveData<>();
    private final MutableLiveData<List<Playlist>> mPlaylist = new MutableLiveData<>();

    public LibraryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<Playlist> getDetailPlayList() {
        return mDetailPlaylist;
    }

    public void setDetailPlaylist(Playlist mPLayList) {
        this.mDetailPlaylist.setValue(mPLayList);
    }

    public MutableLiveData<List<Playlist>> getPlaylist() {
        return mPlaylist;
    }

    public void setPlaylist(List<Playlist> mPlaylist) {
        this.mPlaylist.setValue(mPlaylist);
    }
}