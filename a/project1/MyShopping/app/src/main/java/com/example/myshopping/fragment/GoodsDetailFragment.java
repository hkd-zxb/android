package com.example.myshopping.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myshopping.R;
import com.example.myshopping.adapter.GoodsRecycleAdapter;
import com.example.myshopping.bean.GoodsInfo;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailFragment extends Fragment {
    protected View view;
    private List<String> mTitleList = new ArrayList<>();
    private GoodsInfo goodsInfo;
    protected int mPosition;
    protected int mImageId;
    protected TextView desc;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        view = inflater.inflate(R.layout.fragment_goods_detail, container, false);
        RecyclerView rv_content = view.findViewById(R.id.rv_content);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        rv_content.setLayoutManager(manager);
        GoodsRecycleAdapter adapter = new GoodsRecycleAdapter(mContext);
        rv_content.setAdapter(adapter);
        return view;

    }

}
