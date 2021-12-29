package com.example.myshopping.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myshopping.R;
import com.example.myshopping.adapter.ClassPagerAdapter;
import com.example.myshopping.bean.NewsInfo;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class DepartmentClassFragment extends Fragment {
    private AppCompatActivity activity;
    private List<String> mtitleList = new ArrayList<>();
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (AppCompatActivity) getActivity();
        view = inflater.inflate(R.layout.fragment_department_class, container, false);
        Toolbar tl_head = view.findViewById(R.id.tl_head);
        activity.setSupportActionBar(tl_head);
        mtitleList.add("服装");
        mtitleList.add("电器");
        TabLayout tabLayout = view.findViewById(R.id.tab_title);
        ViewPager2 vp2_content = view.findViewById(R.id.vp2_content);
        ClassPagerAdapter adapter = new ClassPagerAdapter(activity, mtitleList);
        vp2_content.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, vp2_content, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText(mtitleList.get(position)); // 设置每页的标签文字
            }
        }).attach();
        return view;
    }
}
