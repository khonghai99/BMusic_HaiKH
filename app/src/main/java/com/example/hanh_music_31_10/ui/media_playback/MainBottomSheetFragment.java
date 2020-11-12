package com.example.hanh_music_31_10.ui.media_playback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hanh_music_31_10.R;
import com.google.android.material.tabs.TabLayout;

public class MainBottomSheetFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    public MainBottomSheetFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);

//        mViewPager = (ViewPager) view.findViewById(R.id.view_pager_playback);
//        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout_playback);
//        FragmentManager manager = getSupportFragmentManager();
//        PagerAdapter adapter = new PagerAdapter(manager);
//        mViewPager.setAdapter(adapter);
//        mTabLayout.setupWithViewPager(mViewPager);
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.setTabsFromPagerAdapter(adapter);//deprecated
//        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        PagerAdapterBottom pagerAdapter = new PagerAdapterBottom(getChildFragmentManager(), 0);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager_playback);
        mViewPager.setAdapter(pagerAdapter);

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout_playback);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
