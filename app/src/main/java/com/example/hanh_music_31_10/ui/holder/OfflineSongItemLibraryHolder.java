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

public class OfflineSongItemLibraryHolder extends BaseRecyclerViewHolder {
    private TextView mNumber;
    private TextView mNameSongOffline;
    private TextView mDuration;
    private ImageView mOptionOffline;

    public OfflineSongItemLibraryHolder(@NonNull View itemView) {
        super(itemView);
        mNumber = itemView.findViewById(R.id.id_number);
        mNameSongOffline = itemView.findViewById(R.id.id_item_name_song);
        mDuration = itemView.findViewById(R.id.id_item_duration);
        mOptionOffline = itemView.findViewById(R.id.id_option_menu);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Song) {
            Song song = (Song) data;
            mNameSongOffline.setText(song.getNameSong());
            mDuration.setText(song.getDuration());
            mOptionOffline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), mOptionOffline);
                    popupMenu.inflate(R.menu.menu_offline_song);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.like_song:
//                                    addFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.delete_song:
//                                    removeFavoriteSongsList(song.getId());
                                    return true;
                                case R.id.add_playlist_song:
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

    public void setNumber(int i) {
        if (mNumber != null)
            mNumber.setText("" + i);
    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {

    }
}
