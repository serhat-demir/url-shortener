package com.serhat.urlshortenermvvm.ui.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.serhat.urlshortenermvvm.R;
import com.serhat.urlshortenermvvm.databinding.ActivityMainBinding;
import com.serhat.urlshortenermvvm.ui.viewmodel.ShortenUrlViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Context context;
    private ShortenUrlViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);

        context = MainActivity.this;
        viewModel = new ViewModelProvider(this).get(ShortenUrlViewModel.class);

        viewModel.shortUrl.observe(this, shortUrl -> {
            binding.setShortUrl(shortUrl);
        });

        viewModel.toastObserver.observe(this, message -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
    }

    public void shortenUrl(String url) {
        viewModel.shortenUrl(url);
    }

    public void copyUrl(String url) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", url);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(context, getString(R.string.url_copied), Toast.LENGTH_SHORT).show();
    }
}