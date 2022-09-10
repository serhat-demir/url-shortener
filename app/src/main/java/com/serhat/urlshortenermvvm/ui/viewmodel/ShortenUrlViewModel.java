package com.serhat.urlshortenermvvm.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.serhat.urlshortenermvvm.data.model.ShortUrl;
import com.serhat.urlshortenermvvm.data.repository.ShortenUrlRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ShortenUrlViewModel extends ViewModel {
    private ShortenUrlRepository sRepo;
    public MutableLiveData<ShortUrl> shortUrl;
    public MutableLiveData<String> toastObserver;

    @Inject
    public ShortenUrlViewModel(ShortenUrlRepository sRepo) {
        this.sRepo = sRepo;
        shortUrl = sRepo.getShortUrl();
        toastObserver = sRepo.getToastObserver();
    }

    public void shortenUrl(String url) {
        sRepo.shortenUrl(url);
    }
}
