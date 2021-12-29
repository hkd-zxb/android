package com.example.myshopping.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshopping.R;
import com.example.myshopping.adapter.RecycleCartAdapter;

public class DepartmentCartFragment extends Fragment {
    protected View mView; // 声明一个视图对象
    protected AppCompatActivity mActivity; // 声明一个活动对象

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = (AppCompatActivity) getActivity();
        mView = inflater.inflate(R.layout.fragment_department_cart, container, false);
        RecyclerView rv_cart = mView.findViewById(R.id.rv_cart);
        GridLayoutManager manager = new GridLayoutManager(mActivity,1);
        RecycleCartAdapter adapter = new RecycleCartAdapter(mActivity);
        rv_cart.setAdapter(adapter);
        rv_cart.setLayoutManager(manager);
        return mView;
    }
}
