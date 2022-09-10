package com.serhat.urlshortenermvvm.api;

public class ApiUtils {
    public static final String BASE_URL = "https://url-shortener-service.p.rapidapi.com/";
    public static final String API_KEY = "PUT YOUR API KEY HERE";
    public static final String API_HOST = "url-shortener-service.p.rapidapi.com";

    public static ApiInterface getApiService() {
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
