package com.example.hanh_music_31_10.ui.library;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hanh_music_31_10.ui.recycler.RecyclerActionListener;

public class ViewPagerAdapterLibrary extends FragmentStatePagerAdapter {

    public ViewPagerAdapterLibrary(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPagerAdapterLibrary(@NonNull FragmentManager fm) {
        super(fm);
    }
    // HaiKH sự kiện chuyển tab bên thư viên
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OfflineSongFragment();
            case 1:
                return new PlayListFragment();
            case 2:
                return new FavoriteSongFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Ngoại tuyến";
            case 1:
                return "PlayList";
            case 2:
                return "Yêu thích";
        }
        return null;
    }
}
