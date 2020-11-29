package com.example.telemedicine.view.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.telemedicine.R;

public class ProfileFragment extends Fragment {
    WebView map;
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        map = view.findViewById(R.id.web_view);
        map.getSettings().setJavaScriptEnabled(true);
        map.setWebViewClient(new WebViewClient());
        map.loadUrl("https://goo.gl/maps/XUdjnXCiH4kTQYTx5");
        return view;
    }

}
