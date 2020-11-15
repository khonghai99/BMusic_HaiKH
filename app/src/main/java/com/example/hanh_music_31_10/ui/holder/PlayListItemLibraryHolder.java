package com.example.hanh_music_31_10.ui.holder;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class PlayListItemLibraryHolder extends BaseRecyclerViewHolder {

    private ImageView mImagePlaylist;
    private TextView mNamePlayList;
    private TextView mTotalSong;
    private ImageView mOptionPlaylist;

    public PlayListItemLibraryHolder(@NonNull View itemView) {
        super(itemView);
        mImagePlaylist = itemView.findViewById(R.id.id_image_playlist);
        mNamePlayList = itemView.findViewById(R.id.id_name_playlist);
        mTotalSong = itemView.findViewById(R.id.total_song);
        mOptionPlaylist = itemView.findViewById(R.id.id_option_playlist);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Playlist) {
            Playlist mPlayList = (Playlist) data;
            //load anh
            mImagePlaylist.setImageResource(R.drawable.ic_baseline_library_music_24);
            mNamePlayList.setText(mPlayList.getNameCategory());
            mTotalSong.setText(mPlayList.getmSongList().size() + " bài hát ");

            mOptionPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), mOptionPlaylist);
                    popupMenu.inflate(R.menu.menu_playlist_song);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.rename_playlist:
//                                    addFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.delete_playlist:
//                                    removeFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.add_song_to_playlist:
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
