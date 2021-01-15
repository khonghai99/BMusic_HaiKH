package com.example.hanh_music_31_10.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.service.MediaPlaybackService;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class DetailSearchItemHolder extends BaseRecyclerViewHolder {

    private ImageView mImageSearch;
    private TextView mNameSearch;
    private TextView mArtistSearch;
    private ImageView mForWard;

    public DetailSearchItemHolder(@NonNull View itemView) {
        super(itemView);
        mImageSearch = itemView.findViewById(R.id.id_image_search);
        mNameSearch = itemView.findViewById(R.id.id_name_search);
        mArtistSearch = itemView.findViewById(R.id.artist_search);
        mForWard = itemView.findViewById(R.id.forward);
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if (data instanceof Song) {
            Song song = (Song) data;
            //load anh
            mImageSearch.setImageResource(R.drawable.ic_baseline_library_music_24);
            mNameSearch.setText(song.getNameSong());
            mArtistSearch.setText(song.getSinger());
            mForWard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {

    }

    @Override
    public void setService(MediaPlaybackService service) {

    }

}
