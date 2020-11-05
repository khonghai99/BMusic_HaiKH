package com.example.hanh_music_31_10.ui.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.example.hanh_music_31_10.R;
import com.example.hanh_music_31_10.ui.holder.BlockHomeCategoryHolder;
import com.example.hanh_music_31_10.ui.holder.HomeSongItemHolder;

public class ViewHolderFactory {

    public static BaseRecyclerViewHolder createViewHolder(@RecyclerViewType int viewType, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
        switch (viewType) {
            case RecyclerViewType.TYPE_INVALID:
                return new InvalidViewHolder(view);
            case RecyclerViewType.TYPE_BLOCK_HOME_CATEGORY:
                return new BlockHomeCategoryHolder(view);
            case RecyclerViewType.TYPE_ITEM_SONG_IN_HOME:
                return new HomeSongItemHolder(view);
            case RecyclerViewType.TYPE_ARTICLE_STYLE_MEDIUM:
            case RecyclerViewType.TYPE_ARTICLE_STYLE_SMALL:
            case RecyclerViewType.TYPE_NEWS_CATEGORY:
            case RecyclerViewType.TYPE_NEWS_HIDE_SOURCE:
            case RecyclerViewType.TYPE_ARTICLE_DETAIL:
        }
        return new InvalidViewHolder(view);
    }

    @LayoutRes
    private static int getLayoutId(int viewType) {
        switch (viewType) {
            case RecyclerViewType.TYPE_INVALID:
                return 0;
            case RecyclerViewType.TYPE_BLOCK_HOME_CATEGORY:
                return R.layout.block_song_category;
            case RecyclerViewType.TYPE_ITEM_SONG_IN_HOME:
                return R.layout.item_list_in_block;
            case RecyclerViewType.TYPE_ARTICLE_STYLE_MEDIUM:
            case RecyclerViewType.TYPE_ARTICLE_STYLE_SMALL:
            case RecyclerViewType.TYPE_NEWS_CATEGORY:
            case RecyclerViewType.TYPE_NEWS_HIDE_SOURCE:
            case RecyclerViewType.TYPE_ARTICLE_DETAIL:
        }
        return 0;
    }

}
