package com.example.hanh_music_31_10.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.activity.ActivityViewModel;
import com.example.hanh_music_31_10.auth.HomeAuthActivity;
import com.example.hanh_music_31_10.model.PlaySong;
import com.example.hanh_music_31_10.model.Song;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DetailSongFragment extends Fragment implements View.OnClickListener {
    private ImageView mImageView;
    private TextView mTextSong;
    private TextView mArtistSong;
    private TextView mDurationSong;
    private LinearLayout mDownloadSong;
    private ImageView mPlaySong;

    private Song song;

    private HomeViewModel homeViewModel;
    private ActivityViewModel mActivityViewModel;
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

        mActivityViewModel = new ViewModelProvider(requireActivity()).get(ActivityViewModel.class);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mDownloadSong) {
            //download song
            //check xem login chưa, nếu chưa login thì yêu cầu logic hoặc sign up
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            if(user == null){
                //neu chua dang nhap can dang nhap truoc can dang nhap truoc
                Intent intent = new Intent(getActivity(), HomeAuthActivity.class);
                startActivity(intent);
            } else {
                // neu dang dang nhap thi tai luon
                Toast.makeText(getContext()," Tai bai hat ", Toast.LENGTH_LONG).show();
            }

        } else if (v == mPlaySong) {
            //play music
            mActivityViewModel.setPlaylist(new PlaySong(song, new ArrayList<>(Collections.singletonList(song))));
        }
    }

    public void updateSong(Song song) {
        if (song != null) {
            this.song = song;
//            mImageView.setImageResource(R.drawable.ic_baseline_library_music_24);
            Glide.with(mImageView)
                    .load(song.getImageUrl())
                    .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
                    .apply(RequestOptions.
                            placeholderOf(R.drawable.placeholder_music))
                    .into(mImageView);
            mTextSong.setText(song.getNameSong());
            mArtistSong.setText(song.getSinger());
            mDurationSong.setText(new SimpleDateFormat("mm:ss").format(Integer.parseInt(song.getDuration())));
        }
    }
}
