package com.example.hanh_music_31_10.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Song;

public class DetailSongFragment extends Fragment implements View.OnClickListener {
    private ImageView mImageView;
    private TextView mTextSong;
    private TextView mArtistSong;
    private TextView mDurationSong;
    private LinearLayout mDownloadSong;
    private ImageView mPlaySong;

    private HomeViewModel homeViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_song_home, container, false);
        mImageView = view.findViewById(R.id.image_view_detail);
        mTextSong = view.findViewById(R.id.name_song_detail);
        mArtistSong = view.findViewById(R.id.artist_song_detail);
        mDurationSong = view.findViewById(R.id.duration_detail);
        mDownloadSong = view.findViewById(R.id.download_song);
        mPlaySong = view.findViewById(R.id.play_song_detail);

        mDownloadSong.setOnClickListener(this);
        mPlaySong.setOnClickListener(this);

        homeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        homeViewModel.getDetailSong().observe(getViewLifecycleOwner(), new Observer<Song>() {
            @Override
            public void onChanged(Song song) {
                updateSong(song);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mDownloadSong) {
            //download song
        } else if (v == mPlaySong) {
            //play music
        }
    }

    public void updateSong(Song song) {
        if (song != null) {
            mImageView.setImageResource(R.drawable.ic_baseline_library_music_24);
            mTextSong.setText(song.getNameSong());
            mArtistSong.setText(song.getSinger());
            mDurationSong.setText(song.getDuration());
        }
    }
}
