package com.example.hanh_music_31_10.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class FavoriteSongItemLibraryHolder extends BaseRecyclerViewHolder {
    private ImageView mImageFavorite;
    private TextView mNameSongFavorite;
    private TextView mArtist;
    private ImageView mOptionFavorite;

    public FavoriteSongItemLibraryHolder(@NonNull View itemView) {
        super(itemView);
        mImageFavorite = itemView.findViewById(R.id.id_image_favorite);
        mNameSongFavorite = itemView.findViewById(R.id.id_name_song_favorite);
        mArtist = itemView.findViewById(R.id.artist_song_favorite);
        mOptionFavorite = itemView.findViewById(R.id.id_option_favorite);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Song) {
            Song song = (Song) data;
            mImageFavorite.setImageResource(R.drawable.ic_queue_music_black_24dp);
            mNameSongFavorite.setText(song.getNameSong());
            mArtist.setText(song.getSinger());
        }

    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {

    }
}
