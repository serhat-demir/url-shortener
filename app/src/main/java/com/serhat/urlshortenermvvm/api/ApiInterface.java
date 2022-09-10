package com.serhat.urlshortenermvvm.api;

import com.serhat.urlshortenermvvm.data.model.ShortUrl;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("shorten")
    @FormUrlEncoded
    Call<ShortUrl> shortenUrl(
            @Header("X-RapidAPI-KEY") String api_key,
            @Header("X-RapidAPI-Host") String api_host,
            @Field("url") String url
    );
}
