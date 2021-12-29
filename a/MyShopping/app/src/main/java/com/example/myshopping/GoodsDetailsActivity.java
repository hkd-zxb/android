package com.example.myshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myshopping.adapter.GoodsDetailAdapter;

import com.example.myshopping.bean.CartInfo;
import com.example.myshopping.bean.GoodsInfo;
import com.example.myshopping.fragment.GoodsDetailFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailsActivity extends AppCompatActivity{
    private AppCompatActivity activity;
    private List<String> mTitleList = new ArrayList<>();
    private Button btn_like;
    private View rootView;
    List<GoodsInfo> goodsInfoList = new ArrayList<>();
    int flag = 1;
    GoodsDetailFragment fragment = new GoodsDetailFragment();

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);

        rootView = View.inflate(this, R.layout.item_goods, null);
        mTitleList.add("商品");
        mTitleList.add("详情");
        TabLayout tabLayout = findViewById(R.id.tab_title);
        ViewPager2 vp2_content = findViewById(R.id.vp2_content);
        GoodsDetailAdapter adapter = new GoodsDetailAdapter(this, mTitleList);
        vp2_content.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, vp2_content, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mTitleList.get(position));
            }
        }).attach();
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




}