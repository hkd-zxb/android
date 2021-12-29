package com.example.myshopping.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myshopping.fragment.ClothesFragment;

import java.util.List;

public class ClassPagerAdapter extends FragmentStateAdapter {
    private List<String> mTitleList;

    public ClassPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<String> mTitleList) {
        super(fragmentActivity);
        this.mTitleList = mTitleList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ClothesFragment();
        } else {
            return new ClothesFragment();
        }

    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }
}
