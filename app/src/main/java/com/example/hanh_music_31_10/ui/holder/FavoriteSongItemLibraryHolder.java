package com.example.hanh_music_31_10.ui.holder;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.service.MediaPlaybackService;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

import es.claucookie.miniequalizerlibrary.EqualizerView;

public class FavoriteSongItemLibraryHolder extends BaseRecyclerViewHolder {
    private ImageView mImageFavorite;
    private TextView mNameSongFavorite;
    private TextView mArtist;
    private ImageView mOptionFavorite;
    private EqualizerView mEqualizerView;

    private MediaPlaybackService mService;

    public FavoriteSongItemLibraryHolder(@NonNull View itemView) {
        super(itemView);
        mImageFavorite = itemView.findViewById(R.id.id_image_favorite);
        mNameSongFavorite = itemView.findViewById(R.id.id_name_song_favorite);
        mArtist = itemView.findViewById(R.id.artist_song_favorite);
        mOptionFavorite = itemView.findViewById(R.id.id_option_favorite);
        mEqualizerView = itemView.findViewById(R.id.equalizer);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Song) {
            Song song = (Song) data;
//            if (song.loadImageFromPath(song.getPathSong()) == null) {
//                mImageFavorite.setImageResource(R.drawable.ic_queue_music_black_24dp);
//            } else {
//                mImageFavorite.setImageBitmap(song.loadImageFromPath(song.getPathSong()));
//            }
            if(mService != null){
                Song playingSong = mService.getPlayingSong();
                updateEqualizerView(playingSong != null && playingSong.getId() == song.getId() && mService.isMusicPlay() && mService.isPlaying(), song);
            }else {
                updateEqualizerView(false, song);
//                mNumber.setText(""+(getLayoutPosition()+1));
            }
            mNameSongFavorite.setText(song.getNameSong());
            mArtist.setText(song.getSinger());

            mOptionFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), mOptionFavorite);
                    popupMenu.inflate(R.menu.menu_favorite_song);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.dis_like_song:
//                                    addFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.add_playlist_song:
//                                    removeFavoriteSongsList(song.getId());
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    popupMenu.show();
                }
            });
        }

    }

    //update sóng khi phát 1 bài hát
    public void updateEqualizerView(boolean isPlay, Song song){
        if( isPlay ){
            mEqualizerView.animateBars();
        } else if (!mEqualizerView.isAnimating()){
            mEqualizerView.stopBars();
            if (song.loadImageFromPath(song.getPathSong()) == null) {
                mImageFavorite.setImageResource(R.drawable.ic_queue_music_black_24dp);
            } else {
                mImageFavorite.setImageBitmap(song.loadImageFromPath(song.getPathSong()));
            }
        }
        mEqualizerView.setVisibility(isPlay ? View.VISIBLE : View.INVISIBLE);
        mImageFavorite.setVisibility(isPlay ? View.INVISIBLE : View.VISIBLE );
    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.onViewClick(getAdapterPosition(), v, FavoriteSongItemLibraryHolder.this);
            }
        });
    }

    @Override
    public void setService(MediaPlaybackService service) {
        mService = service;
    }
}
