package com.example.myshopping.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myshopping.bean.GoodsInfo;
import com.example.myshopping.fragment.ClothesFragment;
import com.example.myshopping.fragment.DepartmentHomeFragment;
import com.example.myshopping.fragment.GoodsDetailFragment;
import com.example.myshopping.fragment.MobileFragment;

import java.util.List;

public class GoodsDetailAdapter extends FragmentStateAdapter {
    private List<String> mTitleList;

    public GoodsDetailAdapter(@NonNull FragmentActivity fragmentActivity, List<String> mTitleList) {
        super(fragmentActivity);
        this.mTitleList = mTitleList;

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) { // 第一页展示服装
            return new GoodsDetailFragment();
        } else { // 其他页展示电器
            return new MobileFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }
}
