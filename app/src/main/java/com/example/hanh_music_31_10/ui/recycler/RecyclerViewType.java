package com.example.hanh_music_31_10.ui.recycler;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface RecyclerViewType {
    int TYPE_INVALID = 0;

    int TYPE_HOME_BASE = 1989;
    int TYPE_BLOCK_HOME_CATEGORY = TYPE_HOME_BASE + 1;
    int TYPE_ITEM_SONG_IN_HOME = TYPE_HOME_BASE + 3;
    int TYPE_ARTICLE_STYLE_MEDIUM = TYPE_HOME_BASE + 5;
    int TYPE_ARTICLE_STYLE_SMALL = TYPE_HOME_BASE + 6;
    int TYPE_NEWS_CATEGORY = TYPE_HOME_BASE + 7;
    int TYPE_NEWS_HIDE_SOURCE = TYPE_HOME_BASE + 8;
    int TYPE_ARTICLE_DETAIL = TYPE_HOME_BASE + 9;
}
