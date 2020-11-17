package com.example.hanh_music_31_10.ui.holder;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class SongItemInPlayList extends BaseRecyclerViewHolder {
    private ImageView mImageSong;
    private TextView mNameSong;
    private TextView mArtistSong;
    private ImageView mOptionSongInPlaylist;

    public SongItemInPlayList(@NonNull View itemView) {
        super(itemView);
        mImageSong = itemView.findViewById(R.id.id_image_song);
        mNameSong = itemView.findViewById(R.id.id_name_song);
        mArtistSong = itemView.findViewById(R.id.artist_song);
        mOptionSongInPlaylist = itemView.findViewById(R.id.id_option_song_playlist);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if( data instanceof Song){
            Song song = (Song) data;
            mImageSong.setImageResource(R.drawable.ic_baseline_library_music_24);
            mNameSong.setText(song.getNameSong());
            mArtistSong.setText(song.getSinger());
            mOptionSongInPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), mOptionSongInPlaylist);
                    popupMenu.inflate(R.menu.menu_song_in_playlist);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.delete_song_in_playlist:
//                                    addFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.add_favorite:
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

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {

    }
}
