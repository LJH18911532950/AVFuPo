package com.example.myfupo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bumptech.glide.Glide;
import com.example.myfupo.R;
import com.example.myfupo.adapter.LayoutHelperAdapter;
import com.example.myfupo.base.Item;
import com.example.myfupo.interfacer.IHome;
import com.example.myfupo.personter.RecommendPersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;


public class BlankFragment1 extends Fragment implements IHome.View {


    private Banner bannere;
    private RecyclerView recycler;
    private IHome.Persenter persenter;
    private List<Item.DataBean.ChannelBean> channelBeans;
    private LayoutHelperAdapter layoutHelperAdapter;
    private DelegateAdapter delegateAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private Toolbar toobs;

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        persenter = new RecommendPersenter(this);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        persenter.getItem();
    }

    private void initView(View view) {
        bannere = (Banner) view.findViewById(R.id.bannere);
        toobs = (Toolbar) view.findViewById(R.id.toobs);
        toobs.setTitle("");

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
                Item.DataBean.BannerBean bannerBean = (Item.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
    }
}