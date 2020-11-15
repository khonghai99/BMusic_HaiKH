package com.example.hanh_music_31_10.ui.library;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.Playlist;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OfflineSongFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView mRecyclerView;
    private static final int LOADER_ID = 1;
    private List<Song> mListSong = new ArrayList<Song>();
    private BaseRecyclerAdapter<Song> mAdapter;

    private RecyclerActionListener actionListener = new RecyclerActionListener() {
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
            super.onViewClick(position, view, viewHolder);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //load bai hat o tren thiet bi
        getLoaderManager().initLoader(LOADER_ID,null, this);

        View view = inflater.inflate(R.layout.offline_library_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_offline);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new BaseRecyclerAdapter<Song>(actionListener) {
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_OFFLINE_SONG_LIBRARY;
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }



    private List<Song> getData() {
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
        return dataSong3;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(getContext(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        ArrayList<Song> songList = new ArrayList<>();
        if (data != null && data.getCount() > 0) {
            data.moveToFirst();
            int indexIdColumn = data.getColumnIndex(MediaStore.Audio.Media._ID);
            int indexTitleColumn = data.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int indexDataColumn = data.getColumnIndex(MediaStore.Audio.Media.DATA);
            int indexArtistColumn = data.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int indexAlbumIDColumn = data.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
            int indexDurationColumn = data.getColumnIndex(MediaStore.Audio.Media.DURATION);
            do {
                int id = Integer.parseInt(data.getString(indexIdColumn));
                String title = data.getString(indexTitleColumn);
                String path = data.getString(indexDataColumn);
                String artist = data.getString(indexArtistColumn);
                String albumID = data.getString(indexAlbumIDColumn);
                int duration = Integer.parseInt(data.getString(indexDurationColumn));
                SimpleDateFormat formatTimeSong = new SimpleDateFormat("mm:ss");
                String timeSong = formatTimeSong.format(duration);
                Song song = new Song(id, title, path, artist, albumID, timeSong);
                songList.add(song);

//                if (!checkIdExitFavoriteSongs(id)){
//                    addIdProviderForFavoriteSongsList(id);
//                }

            } while (data.moveToNext());
        }
        mListSong = songList;
        mAdapter.update(songList);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
    }

//    public ArrayList<Integer> loadIdProviderFromFavoriteSongs(){
//        ArrayList<Integer> listId = new ArrayList<>();
//        Cursor c = getActivity().getContentResolver().query(FavoriteSongsProvider.CONTENT_URI, null, null, null, null);
//        if (c.moveToFirst()){
//            do {
//                int id = Integer.parseInt(c.getString(c.getColumnIndex(FavoriteSongsProvider.ID_PROVIDER)));
//                listId.add(id);
//            } while (c.moveToNext());
//        }
//        return listId;
//    }
//
//    public boolean checkIdExitFavoriteSongs(int id){
//        ArrayList<Integer> list = loadIdProviderFromFavoriteSongs();
//        if (list.contains(id))
//            return true;
//        else
//            return false;
//    }
//
//    public void addIdProviderForFavoriteSongsList(int id) {
//        ContentValues values = new ContentValues();
//
//        values.put(FavoriteSongsProvider.ID_PROVIDER,
//                id);
//
//        Uri uri = getActivity().getContentResolver().insert(
//                FavoriteSongsProvider.CONTENT_URI, values);
//        Toast.makeText(getActivity(),
//                uri.toString(), Toast.LENGTH_LONG).show();
//    }
}
