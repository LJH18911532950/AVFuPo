package com.example.myfupo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.LogTime;
import com.example.myfupo.R;
import com.example.myfupo.base.Item;

import java.util.List;

public class LayoutHelperAdapter extends BaseAdapter {

    public LayoutHelperAdapter(List mData, Context context) {
        super(mData, context);
    }

    @Override
    protected int getLatyou() {
        return R.layout.layout_item;
    }

    @Override
    protected void bind(Object date, VH vh) {
        Item.DataBean.ChannelBean channelBean= (Item.DataBean.ChannelBean) date;
        ImageView iv_image = (ImageView) vh.getViewByid(R.id.iv_image);
        TextView tv_title = (TextView) vh.getViewByid(R.id.tv_title);
        Glide.with(vh.itemView).load(channelBean.getIcon_url()).into(iv_image);
        tv_title.setText(channelBean.getName());

    }
}
