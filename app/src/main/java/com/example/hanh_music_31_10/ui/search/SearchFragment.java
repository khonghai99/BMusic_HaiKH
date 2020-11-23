package com.example.hanh_music_31_10.ui.search;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.ImageSearchModel;
import com.example.hanh_music_31_10.model.Song;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayout;
    RecyclerActionListener mRecyclerViewAction = new RecyclerActionListener(){
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        mSearchView = root.findViewById(R.id.search_view);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        System.out.println("HanhNTHe; searchManager "+searchManager);

        mRecyclerView = root.findViewById(R.id.recycler_view_search);
        mRecyclerView.setHasFixedSize(true);

        mGridLayout = new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(mGridLayout);

        BaseRecyclerAdapter<ImageSearchModel> adapter = new BaseRecyclerAdapter<ImageSearchModel>(getData(),mRecyclerViewAction){
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_IMAGE_SEARCH;
            }
        };

        mRecyclerView.setAdapter(adapter);

        return root;
    }

    private List<ImageSearchModel> getData(){
        List<ImageSearchModel> data = new ArrayList<ImageSearchModel>();
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        data.add(new ImageSearchModel(1,R.drawable.icon_default_song));
        return data;
    }

}