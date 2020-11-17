package com.example.hanh_music_31_10.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

import java.util.List;

public class DetailPlayListFragment extends Fragment {

    private TextView mTitlePlayList;
    private RecyclerView mListSong;
    BaseRecyclerAdapter<Song> mAdapter;

    RecyclerActionListener mRecyclerActionListener = new RecyclerActionListener() {
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
        }

        @Override
        public void onViewLongClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
        }

        @Override
        public void clickSong(Song song) {
            super.clickSong(song);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.detail_playlist_fragment, container, false);
        mTitlePlayList = root.findViewById(R.id.title_playlist);

        mListSong = root.findViewById(R.id.recycler_song_in_playlist);
        mListSong.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mListSong.setLayoutManager(layoutManager);

        mAdapter = new BaseRecyclerAdapter<Song>(mRecyclerActionListener){
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_SONG_IN_PLAYLIST;
            }
        };

        mListSong.setAdapter(mAdapter);
        return root;
    }

    public void updateListSongInPlaylist(List<Song> songs){
        mAdapter.update(songs);
    }

}
