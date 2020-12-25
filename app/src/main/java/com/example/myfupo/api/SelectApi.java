package com.example.myfupo.api;

import com.example.myfupo.base.Item;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SelectApi {
    String URL="https://cdwan.cn/";
    @GET("api/index")
    Observable<Item>getItem();
}
