package com.example.myfupo.Mdelo;

import android.util.Log;


import androidx.annotation.LongDef;

import com.bumptech.glide.util.LogTime;
import com.example.myfupo.api.SelectApi;
import com.example.myfupo.base.Item;
import com.example.myfupo.interfacer.Classback;
import com.example.myfupo.interfacer.IHome;
import com.example.myfupo.net.HttpManage;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RecommendModel implements IHome.Mdelo {
    private static final String TAG = "RecommendModel";

    @Override
    public void getMdelo1(final Classback classback) {
        HttpManage.getHttpManage().getSelectApi()
                .getItem()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Item>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Item item) {
                        classback.onSecc(item);
                        Log.d(TAG, "onNext: "+item);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
