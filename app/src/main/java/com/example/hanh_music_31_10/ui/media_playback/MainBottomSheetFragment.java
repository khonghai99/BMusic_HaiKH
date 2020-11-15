package com.example.hanh_music_31_10.ui.media_playback;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hanh_music_31_10.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.tabs.TabLayout;

public class MainBottomSheetFragment extends BottomSheetDialogFragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ccnews_fragment_articles, container, false);

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

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null) return;
        View bottomSheet = dialog.findViewById(R.id.design_bottom_sheet);
        bottomSheet.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) bottomSheet.getLayoutParams();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = (BottomSheetBehavior<FrameLayout>) params.getBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setSkipCollapsed(true);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
//        int offsetTop = getContext().getResources().getDimensionPixelOffset(R.dimen.ccnews_padding_16);
//        bottomSheetBehavior.setFitToContents(false);
//        bottomSheetBehavior.setExpandedOffset(offsetTop);
//        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                if (newState == BottomSheetBehavior.STATE_DRAGGING && !mPullDownEnable) {
//                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });
    }
}
