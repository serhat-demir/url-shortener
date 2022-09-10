package com.serhat.urlshortenermvvm.data.repository;

import android.util.Patterns;

import androidx.lifecycle.MutableLiveData;

import com.serhat.urlshortenermvvm.api.ApiInterface;
import com.serhat.urlshortenermvvm.api.ApiUtils;
import com.serhat.urlshortenermvvm.data.model.ShortUrl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShortenUrlRepository {
    private MutableLiveData<ShortUrl> shortUrl;
    private MutableLiveData<String> toastObserver;
    private ApiInterface apiService;

    public ShortenUrlRepository(ApiInterface apiService) {
        shortUrl = new MutableLiveData<>();
        toastObserver = new MutableLiveData<>();
        this.apiService = apiService;
    }

    public MutableLiveData<ShortUrl> getShortUrl() {
        return shortUrl;
    }

    public MutableLiveData<String> getToastObserver() {
        return toastObserver;
    }

    public void shortenUrl(String url) {
        if (Patterns.WEB_URL.matcher(url).matches()) {
            Call<ShortUrl> request = apiService.shortenUrl(ApiUtils.API_KEY, ApiUtils.API_HOST, url);
            request.enqueue(new Callback<ShortUrl>() {
                @Override
                public void onResponse(Call<ShortUrl> call, Response<ShortUrl> response) {
                    if (response.body() != null && response.isSuccessful()) {
                        shortUrl.setValue(response.body());
                        toastObserver.setValue("url has been shortened");
                    } else {
                        toastObserver.setValue("url couldn't be shortened");
                    }
                }

                @Override
                public void onFailure(Call<ShortUrl> call, Throwable t) {
                    toastObserver.setValue("url couldn't be shortened");
                }
            });
        } else {
            toastObserver.setValue("invalid url");
        }
    }
}
