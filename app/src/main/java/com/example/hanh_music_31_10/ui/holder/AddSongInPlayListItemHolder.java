package com.example.hanh_music_31_10.ui.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.service.MediaPlaybackService;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerData;

public class AddSongInPlayListItemHolder extends BaseRecyclerViewHolder {

    private CheckBox mSelectSong;

    public AddSongInPlayListItemHolder(@NonNull View itemView) {
        super(itemView);
        mSelectSong = itemView.findViewById(R.id.item_song);
        attachListener();
    }

    @Override
    public void bindViewHolder(RecyclerData data) {
        if(data instanceof Song){
            Song song = (Song) data;
            System.out.println("hanhnthe song name "+song.getNameSong());
            mSelectSong.setText(song.getNameSong());
        }

    }

    @Override
    public void setupClickableViews(RecyclerActionListener actionListener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionListener.onViewClick(getAdapterPosition(), v, AddSongInPlayListItemHolder.this);
            }
        });
    }

    @Override
    public void setService(MediaPlaybackService service) {
    }

    //Listener nhận sự kiện khi các Checkbox thay đổi trạng thái
    CompoundButton.OnCheckedChangeListener m_listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            System.out.println("HanhNTHe: compoundButton "+compoundButton +"  text "+compoundButton.getText());
        }
    };

    //Gán Listener vào CheckBox
    void attachListener() {
        mSelectSong.setOnCheckedChangeListener(m_listener);
    }
}
