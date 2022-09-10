package com.serhat.urlshortenermvvm.di;

import com.serhat.urlshortenermvvm.api.ApiInterface;
import com.serhat.urlshortenermvvm.api.ApiUtils;
import com.serhat.urlshortenermvvm.data.repository.ShortenUrlRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public ShortenUrlRepository provideShortenUrlRepository(ApiInterface apiService) {
        return new ShortenUrlRepository(apiService);
    }

    @Provides
    @Singleton
    public ApiInterface provideApiInterface() {
        return ApiUtils.getApiService();
    }
}
