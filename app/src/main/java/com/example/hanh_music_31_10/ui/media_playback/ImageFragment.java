package com.example.hanh_music_31_10.ui.media_playback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hanh_music_31_10.R;

public class ImageFragment extends Fragment {

    private ImageView mImageSongMedia;

    public ImageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_song_media, container, false);
        mImageSongMedia = view.findViewById(R.id.image_song_media_play);
        return view;
    }

    public void updateImageSong(){

    }
}
