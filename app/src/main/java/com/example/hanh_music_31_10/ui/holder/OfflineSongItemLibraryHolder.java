package com.example.hanh_music_31_10.ui.holder;

import android.annotation.SuppressLint;
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

public class OfflineSongItemLibraryHolder extends BaseRecyclerViewHolder {
    private TextView mNumber;
    private TextView mNameSongOffline;
    private TextView mDuration;
    private ImageView mOptionOffline;
    private EqualizerView mEqualizerView;

    //Xu ly su kien popup menu
    private PopupMenu mPopupMenu;
    private MediaPlaybackService mService;

    public OfflineSongItemLibraryHolder(@NonNull View itemView) {
        super(itemView);
        mNumber = itemView.findViewById(R.id.id_number);
        mNameSongOffline = itemView.findViewById(R.id.id_item_name_song);
        mDuration = itemView.findViewById(R.id.id_item_duration);
        mOptionOffline = itemView.findViewById(R.id.id_option_menu);
        mEqualizerView = itemView.findViewById(R.id.equalizer);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Song) {
            Song song = (Song) data;
            if(mService != null){
                Song playingSong = mService.getPlayingSong();
                updateEqualizerView(playingSong != null && playingSong.getId() == song.getId() && mService.isMusicPlay() && mService.isPlaying());
            }else {
                updateEqualizerView(false);
//                mNumber.setText(""+(getLayoutPosition()+1));
            }
            mNumber.setText(""+(getLayoutPosition()+1));
            mNameSongOffline.setText(song.getNameSong());
            mDuration.setText(song.getDuration());
            mOptionOffline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupMenu = new PopupMenu(itemView.getContext(), mOptionOffline);
                    mPopupMenu.inflate(R.menu.menu_offline_song);
                    mPopupMenu.show();
                }
            });
        }
    }
    //update sóng khi phát 1 bài hát
    @SuppressLint("SetTextI18n")
    public void updateEqualizerView(boolean isPlay){
        if( isPlay ){
            mEqualizerView.animateBars();
        } else if (!mEqualizerView.isAnimating()){
            mEqualizerView.stopBars();
//            mNumber.setText(""+(getLayoutPosition()+1));
        }
        mEqualizerView.setVisibility(isPlay ? View.VISIBLE : View.INVISIBLE);
        mNumber.setVisibility(isPlay ? View.INVISIBLE : View.VISIBLE );
    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.onViewClick(getAdapterPosition(), v, OfflineSongItemLibraryHolder.this);
            }
        });

        if(mPopupMenu != null){
            mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
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
        }
    }

    @Override
    public void setService(MediaPlaybackService service) {
        mService = service;
    }
}
