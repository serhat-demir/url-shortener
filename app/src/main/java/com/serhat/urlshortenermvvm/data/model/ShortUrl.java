package com.serhat.urlshortenermvvm.data.model;

import com.google.gson.annotations.SerializedName;

public class ShortUrl {
    @SerializedName("result_url")
    private String resultUrl;

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }
}