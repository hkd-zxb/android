package com.example.myshopping.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshopping.R;
import com.example.myshopping.bean.CartInfo;

import com.example.myshopping.provider.CartsInfoContent;


import java.util.ArrayList;
import java.util.List;

public class RecycleCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext; // 声明一个上下文对象
    private List<CartInfo> cartInfoList = new ArrayList<>();
    public RecycleCartAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_cart, parent, false);
        return new ItemHolder(v);
    }

    @SuppressLint("Range")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemHolder holder1 = (ItemHolder) holder;
        CartInfo cartInfo=new CartInfo();
        Cursor cursor = mContext.getContentResolver().query(CartsInfoContent.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            cartInfo.pic = cursor.getInt(cursor.getColumnIndex(CartsInfoContent.PIC));
            cartInfo.desc = cursor.getString(cursor.getColumnIndex(CartsInfoContent.GOODS_DESC));
            cartInfoList.add(cartInfo);
        }
        cursor.close(); // 关闭数据库游标
        for (CartInfo carts : cartInfoList) { // 遍历用户信息列表
            holder1.tv_desc.setText(carts.desc);
//            holder1.iv_pic.setImageResource(carts.pic);
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_item;
        private ImageView iv_pic;
        private TextView tv_desc;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
         ll_item=itemView.findViewById(R.id.ll_item1);
         iv_pic=itemView.findViewById(R.id.iv_pic1);
         tv_desc=itemView.findViewById(R.id.tv_desc);
        }
    }
}
