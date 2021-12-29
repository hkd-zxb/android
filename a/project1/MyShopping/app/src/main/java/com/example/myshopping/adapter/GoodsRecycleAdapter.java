package com.example.myshopping.adapter;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshopping.R;
import com.example.myshopping.bean.CartInfo;
import com.example.myshopping.bean.GoodsInfo;
import com.example.myshopping.provider.CartsInfoContent;
import com.example.myshopping.provider.GoodsInfoContent;

import java.util.ArrayList;
import java.util.List;

public class GoodsRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = "GoodsRecycleAdapter";
    public static  int flag=1;
    private Context mContext; // 声明一个上下文对象
    List<GoodsInfo> goodsInfoList = new ArrayList<>();

    public GoodsRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_goods, parent, false);
        return new ItemHolder(v);
    }

    @SuppressLint("Range")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        ItemHolder holder1 = (ItemHolder) holder;
        GoodsInfo goodsInfo = new GoodsInfo();
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        holder1.btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag) {
                    case 0:
                        holder1.btn_like.setActivated(false);
                        flag = 1;
                        Toast.makeText(v.getContext(), "取消收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        holder1.btn_like.setActivated(true);
                        flag = 0;
                        Toast.makeText(v.getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        holder1.btn_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartInfo cartInfo = new CartInfo();
                cartInfo.desc = holder1.tv_desc.getText().toString();
                cartInfo.pic = holder1.iv_pic.getImageAlpha();
                ContentValues values = new ContentValues();
                values.put("desc", cartInfo.desc);
                values.put("pic", cartInfo.pic);
                mContext.getContentResolver().insert(CartsInfoContent.CONTENT_URI, values);
                Toast.makeText(mContext, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
        Cursor cursor = mContext.getContentResolver().query(GoodsInfoContent.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            goodsInfo.pic = cursor.getInt(cursor.getColumnIndex(GoodsInfoContent.PIC));
            goodsInfo.desc = cursor.getString(cursor.getColumnIndex(GoodsInfoContent.GOODS_DESC));
            goodsInfoList.add(goodsInfo);
        }
        cursor.close(); // 关闭数据库游标
        for (GoodsInfo goods : goodsInfoList) { // 遍历用户信息列表
            holder1.tv_desc.setText(goods.desc);
            holder1.iv_pic.setImageResource(goods.pic);

        }

    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView iv_pic; // 声明列表项图标的图像视图
        public TextView tv_desc; // 声明列表项描述的文本视图
        public Button btn_add_cart;
        public Button btn_like;

        public ItemHolder(View v) {
            super(v);
            btn_add_cart = v.findViewById(R.id.btn_add_cart);
            iv_pic = v.findViewById(R.id.iv_pic);
            tv_desc = v.findViewById(R.id.tv_desc1);
            btn_like = v.findViewById(R.id.btn_like);
        }
    }
}
