package com.example.myshopping.adapter;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.myshopping.GoodsDetailsActivity;
import com.example.myshopping.R;
import com.example.myshopping.bean.GoodsInfo;
import com.example.myshopping.provider.GoodsInfoContent;
import com.example.myshopping.widget.RecyclerExtras;

import java.util.List;

public class MobileGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        RecyclerExtras.OnItemClickListener, RecyclerExtras.OnItemLongClickListener {
    private final static String TAG = "MobileGridAdapter";
    private Context mContext; // 声明一个上下文对象
    private List<GoodsInfo> mGoodsList;

    public MobileGridAdapter(Context context, List<GoodsInfo> goodsList) {
        mContext = context;
        mGoodsList = goodsList;
    }

    // 获取列表项的个数
    public int getItemCount() {
        return mGoodsList.size();
    }

    // 创建列表项的视图持有者
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        // 根据布局文件item_grid.xml生成视图对象
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_grid, vg, false);
        return new ItemHolder(v);
    }

    // 绑定列表项的视图持有者
    public void onBindViewHolder(RecyclerView.ViewHolder vh, @SuppressLint("RecyclerView") final int position) {
        ItemHolder holder = (ItemHolder) vh;
        holder.iv_pic.setImageResource(mGoodsList.get(position).pic);
        holder.tv_title.setText(mGoodsList.get(position).name);
        // 列表项的点击事件需要自己实现
        holder.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
        // 列表项的长按事件需要自己实现
        holder.ll_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null) {
                    mOnItemLongClickListener.onItemLongClick(v, position);
                }
                return true;
            }
        });
    }

    // 获取列表项的类型
    public int getItemViewType(int position) {
        return 0;
    }

    // 获取列表项的编号
    public long getItemId(int position) {
        return position;
    }

    // 定义列表项的视图持有者
    public class ItemHolder extends RecyclerView.ViewHolder {
        public LinearLayout ll_item; // 声明列表项的线性布局
        public ImageView iv_pic; // 声明列表项图标的图像视图
        public TextView tv_title; // 声明列表项标题的文本视图

        public ItemHolder(View v) {
            super(v);
            ll_item = v.findViewById(R.id.ll_item);
            iv_pic = v.findViewById(R.id.iv_pic);
            tv_title = v.findViewById(R.id.tv_title);
        }
    }

    // 声明列表项的点击监听器对象
    private RecyclerExtras.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(RecyclerExtras.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    // 声明列表项的长按监听器对象
    private RecyclerExtras.OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemLongClickListener(RecyclerExtras.OnItemLongClickListener listener) {
        this.mOnItemLongClickListener = listener;
    }

    // 处理列表项的点击事件
    public void onItemClick(View view, int position) {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.desc = mGoodsList.get(position).desc;
        goodsInfo.pic = mGoodsList.get(position).pic;
        goodsInfo.name = mGoodsList.get(position).name;
        goodsInfo.price = mGoodsList.get(position).price;
        ContentValues values = new ContentValues();
        values.put("desc", goodsInfo.desc);
        values.put("name", goodsInfo.name);
        values.put("pic", goodsInfo.pic);
        values.put("price", goodsInfo.price);
        mContext.getContentResolver().insert(GoodsInfoContent.CONTENT_URI, values);
        Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
        Log.d(TAG, goodsInfo.desc);
        mContext.startActivity(intent);
    }

    // 处理列表项的长按事件
    public void onItemLongClick(View view, int position) {

    }

}
