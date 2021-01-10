package com.example.hanh_music_31_10.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.model.ImageSearchModel;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerAdapter;
import com.example.hanh_music_31_10.ui.recycler.BaseRecyclerViewHolder;
import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;
import com.example.hanh_music_31_10.ui.recycler.RecyclerViewType;

import java.util.ArrayList;

public class DetailSearchFragment extends Fragment {

    private TextView mTitleSearch;
    private RecyclerView mRecyclerView;
    private SearchViewModel searchViewModel;
    RecyclerActionListener mRecyclerViewAction = new RecyclerActionListener(){
        @Override
        public void onViewClick(int position, View view, BaseRecyclerViewHolder viewHolder) {
            super.onViewClick(position, view, viewHolder);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        mTitleSearch = root.findViewById(R.id.title_search);

        mRecyclerView = root.findViewById(R.id.recycler_view_podcasts);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        BaseRecyclerAdapter<ImageSearchModel> adapter = new BaseRecyclerAdapter<ImageSearchModel>(new ArrayList<>(), mRecyclerViewAction){
            @Override
            public int getItemViewType(int position) {
                return RecyclerViewType.TYPE_IMAGE_SEARCH;
            }
        };

        mRecyclerView.setAdapter(adapter);

        return root;
    }
}
