package com.example.hanh_music_31_10.ui.library;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.activity.ActivityViewModel;
import com.example.hanh_music_31_10.activity.AddSongToPlaylist;
import com.example.hanh_music_31_10.activity.MainActivity;
import com.example.hanh_music_31_10.model.PlaySong;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

import java.util.ArrayList;
import java.util.List;

public class DetailPlayListFragment extends Fragment {

    private TextView mTitlePlayList;
    private RecyclerView mListSong;
    private TextView mNotifyEmpty;
    BaseRecyclerAdapter<Song> mAdapter;
    private LinearLayout mAddSongInPlaylistButton;

    private ActivityViewModel mActivityViewModel;
    private LibraryViewModel mLibraryViewModel;

    RecyclerActionListener mRecyclerActionListener = new RecyclerActionListener() {
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
            mActivityViewModel.setPlaylist(new PlaySong(position, new ArrayList<>(mAdapter.getData())));
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
        mNotifyEmpty = root.findViewById(R.id.notify_empty);
        mAddSongInPlaylistButton = root.findViewById(R.id.add_song_playlist_button);

        mListSong = root.findViewById(R.id.recycler_song_in_playlist);
        mListSong.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mListSong.setLayoutManager(layoutManager);

        mAdapter = new BaseRecyclerAdapter<Song>(mRecyclerActionListener, ((MainActivity) getActivity()).getService()) {
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_SONG_IN_PLAYLIST;
            }
        };

        mListSong.setAdapter(mAdapter);

        mActivityViewModel = new ViewModelProvider(requireActivity()).get(ActivityViewModel.class);

        mLibraryViewModel = new ViewModelProvider(requireActivity()).get(LibraryViewModel.class);
        mLibraryViewModel.getDetailPlayList().observe(getViewLifecycleOwner(), new Observer<Playlist>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(Playlist playlist) {
                if (playlist != null) {
                    mTitlePlayList.setText("Tên Playlist: "+playlist.getNamePlaylist());
                    if(playlist.getSongList().size() == 0){
                        mNotifyEmpty.setVisibility(View.VISIBLE);
                        mListSong.setVisibility(View.GONE);
                        mAddSongInPlaylistButton.setVisibility(View.VISIBLE);
                        mNotifyEmpty.setText("Chưa có bài hát");
                    }else{
                        mNotifyEmpty.setVisibility(View.GONE);
                        mAddSongInPlaylistButton.setVisibility(View.GONE);
                        mListSong.setVisibility(View.VISIBLE);
                        updateListSongInPlaylist(playlist.getSongList());
                        mActivityViewModel.setDetailPlaylist(null);
                    }
                }
            }
        });

        mAddSongInPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddSongToPlaylist.class);
                startActivity(intent);
            }
        });

        return root;
    }

    public void updateListSongInPlaylist(List<Song> songs) {
        if( songs.size() == 0 ){

        }
        mAdapter.update(songs);
    }

}
