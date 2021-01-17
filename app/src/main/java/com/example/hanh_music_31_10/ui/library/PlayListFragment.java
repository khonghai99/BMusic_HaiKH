package com.example.hanh_music_31_10.ui.library;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.activity.AddSongToPlaylist;
import com.example.hanh_music_31_10.activity.MainActivity;
import com.example.hanh_music_31_10.activity.SettingsActivity;
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

    private Playlist mNewPlaylist;
    private ArrayList<Playlist> mListPlaylist = new ArrayList<>();

    private LibraryViewModel mLibViewModel;
    BaseRecyclerAdapter<Playlist> mAdapter;

    private RecyclerActionListener actionListener = new RecyclerActionListener() {
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
            // click vao 1 view trong playlist fragment chuyển sang fragment detail
//            mOnClickListener.onViewClick(position, view, viewHolder);
            mLibViewModel.setPlaylistFirstClick(mAdapter.getData().get(position));
            System.out.println("HanhNTHe: Click view playlist fragment " + view.toString());
        }

        @Override
        public void updatePlaylistFromButton(Playlist playlist, CONTROL_UPDATE state) {
            switch (state) {
                case UPDATE_NAME_PLAYLIST:
                    editNamePlaylist(playlist);
                    break;
                case ADD_SONG_TO_PLAYLIST:
                    addSongToPlaylist(playlist);
                    break;
                case DELETE_PLAYLIST:
                    deletePlaylist(playlist);
                    break;
            }
        }
    };

    public PlayListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_library_fragment, container, false);

        mButtonNewPlayList = view.findViewById(R.id.line1);
        mButtonNewPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen giao dien tao playlist
                disPlayDialogCreatePlayList();
            }
        });
        mRecyclerView = view.findViewById(R.id.recycler_playlist);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new BaseRecyclerAdapter<Playlist>(actionListener, ((MainActivity) getActivity()).getService()) {
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_PLAYLIST_LIBRARY;
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        mLibViewModel =
                new ViewModelProvider(requireActivity()).get(LibraryViewModel.class);

        return view;
    }

    private void disPlayDialogCreatePlayList() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_create_playlist, null);
        final EditText titlePlaylist = (EditText) alertLayout.findViewById(R.id.input_name_playlist);

//        final Button exitButton = (Button) alertLayout.findViewById(R.id.btn_exit);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // su kien exit
//            }
//        });
//
//        final Button agreeButton = (Button) alertLayout.findViewById(R.id.btn_action);
//        agreeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Đã Hủy", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Tạo Playlist", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                String user = titlePlaylist.getText().toString();
                mNewPlaylist = new Playlist();
                mNewPlaylist.setNamePlaylist(user);
                mListPlaylist.add(mNewPlaylist);
                mAdapter.update(mListPlaylist);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Đã tạo danh sách phát: " + user, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void editNamePlaylist(Playlist playlist) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_create_playlist, null);
        final EditText titlePlaylist = (EditText) alertLayout.findViewById(R.id.input_name_playlist);
        TextView title = alertLayout.findViewById(R.id.title_dialog_create_playList);
        title.setText("Đổi tên Playlist");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            titlePlaylist.setHint(playlist.getNamePlaylist());
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Đã Hủy", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Cập nhật", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                mListPlaylist.remove(playlist);
                String user = titlePlaylist.getText().toString();
                playlist.setNamePlaylist(user);
                mListPlaylist.add(playlist);
                mAdapter.update(mListPlaylist);
                mAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Đã cập nhật tên thành: " + user, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void deletePlaylist(Playlist playlist) {
        //delete playlist user
    }

    private void addSongToPlaylist(Playlist playlist) {
        Intent intent = new Intent(getActivity(), AddSongToPlaylist.class);
        startActivity(intent);
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
