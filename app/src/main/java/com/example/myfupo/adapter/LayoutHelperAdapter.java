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

public class LayoutHelperAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private List<Item.DataBean.ChannelBean> bean;
    private Context context;
    private static final String TAG = "LayoutHelperAdapter";
    public LayoutHelperAdapter(LinearLayoutHelper linearLayoutHelper, List<Item.DataBean.ChannelBean> bean, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.bean = bean;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        Log.d(TAG, "onBindViewHolder: "+"244444444444444444444444");
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+"231133333333333333333");
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        RequestOptions placeholder = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher);
        Glide.with(context).load(bean.get(position).getIcon_url()).apply(placeholder).into(myViewHolder.imageView);
        myViewHolder.textView.setText(bean.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView=itemView.findViewById(R.id.iv_image);
        }
    }
}
