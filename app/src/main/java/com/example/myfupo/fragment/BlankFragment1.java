package com.example.myfupo.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myfupo.R;
import com.example.myfupo.adapter.LayoutHelperAdapter;
import com.example.myfupo.base.Item;
import com.example.myfupo.interfacer.IHome;
import com.example.myfupo.personter.RecommendPersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment1 extends Fragment implements IHome.View {


    private Banner bannere;
    private RecyclerView recycler;
    private IHome.Persenter persenter;
    private List<Item.DataBean.ChannelBean> channelBeans;
    private LayoutHelperAdapter layoutHelperAdapter;
    private DelegateAdapter delegateAdapter;
    private VirtualLayoutManager virtualLayoutManager;

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        persenter=new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        persenter.getItem();
    }

    private void initView(View view) {
        bannere = (Banner) view.findViewById(R.id.bannere);
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        virtualLayoutManager = new VirtualLayoutManager(getContext());
        recycler.setLayoutManager(virtualLayoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        //设置线性布局
        // 创建对应的LayoutHelper对象
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(5);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离


        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);

        channelBeans = new ArrayList<>();
        layoutHelperAdapter = new LayoutHelperAdapter(linearLayoutHelper, channelBeans, getContext());
        delegateAdapter.addAdapter(layoutHelperAdapter);
        recycler.setLayoutManager(virtualLayoutManager);
        recycler.setAdapter(delegateAdapter);
        recycler.setAdapter(layoutHelperAdapter);
    }

    private static final String TAG = "BlankFragment1";
    @Override
    public void getItem(Item item) {
        final List<Item.DataBean.BannerBean> banner = item.getData().getBanner();
        List<Item.DataBean.ChannelBean> channel = item.getData().getChannel();
        bannere.setImages(banner);
        bannere.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Item.DataBean.BannerBean bannerBean= (Item.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
        channelBeans.addAll(channel);
        layoutHelperAdapter.notifyDataSetChanged();
        Log.d(TAG, "getItem: "+channel);
    }
}