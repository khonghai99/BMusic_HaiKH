package com.example.hanh_music_31_10.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.hanh_music_31_10.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    private LibraryViewModel libraryViewModel;
    //list fragment
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        libraryViewModel =
                new ViewModelProvider(this).get(LibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);
        libraryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPagerAdapterLibrary adapterLibrary = new ViewPagerAdapterLibrary(getChildFragmentManager());

        ViewPager viewPager = view.findViewById(R.id.pager_library);
        viewPager.setAdapter(adapterLibrary);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout_library);
        tabLayout.setupWithViewPager(viewPager);
    }
}