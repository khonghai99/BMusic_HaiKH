package com.example.hanh_music_31_10.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

import java.util.ArrayList;
import java.util.List;

public class PlayListFragment extends Fragment {
    private LinearLayout mButtonNewPlayList;
    private RecyclerView mRecyclerView;
    private RecyclerActionListener actionListener = new RecyclerActionListener() {
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
            super.onViewClick(position, view, viewHolder);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_library_fragment, container, false);

        mButtonNewPlayList = view.findViewById(R.id.line1);
        mButtonNewPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen giao dien tao playlist
            }
        });
        mRecyclerView = view.findViewById(R.id.recycler_playlist);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        BaseRecyclerAdapter<Playlist> adapter = new BaseRecyclerAdapter<Playlist>(getData(), actionListener) {
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_PLAYLIST_LIBRARY;
            }
        };
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    private List<Playlist> getData() {
        List<Playlist> data = new ArrayList<Playlist>();
        List<Song> dataSong = new ArrayList<Song>();
        dataSong.add(new Song(1, "Em khong sai chung ta sai", "", "erics", "", "4:2", 0, ""));
        dataSong.add(new Song(1, "Em khong sai chung ta sai", "", "erics", "", "4:2", 0, ""));
        dataSong.add(new Song(1, "Em khong sai chung ta sai", "", "erics", "", "4:2", 0, ""));
        dataSong.add(new Song(1, "Em khong sai chung ta sai", "", "erics", "", "4:2", 0, ""));
        dataSong.add(new Song(1, "Em khong sai chung ta sai", "", "erics", "", "4:2", 0, ""));
        data.add(new Playlist(1, "em khong sai chung ta sai", dataSong));
        List<Song> dataSong1 = new ArrayList<Song>();
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong1.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        data.add(new Playlist(1, " Ta da Tung Yeu ", dataSong1));
        List<Song> dataSong2 = new ArrayList<Song>();
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong2.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        data.add(new Playlist(1, "Muon mang la tu luc", dataSong2));
        List<Song> dataSong3 = new ArrayList<Song>();
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Muon Mang la Tu Luc", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        dataSong3.add(new Song(2, "Tung yeu", "", "Phan Duy Anh", "", "5:13", 0, ""));
        data.add(new Playlist(1, "Anh yeu nguoi khac roi", dataSong3));
        return data;
    }
}
