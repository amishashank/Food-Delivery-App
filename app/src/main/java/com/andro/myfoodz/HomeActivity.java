package com.andro.myfoodz;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    HorizontalScrollView home_horizontal_scroll;
    LinearLayout home_corosuel;

    private List<Integer> bannerList;
    private int currentPosition = 0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Initialize views
        home_horizontal_scroll = findViewById(R.id.home_horizontal_scroll);
        home_corosuel = findViewById(R.id.home_corosuel);

        // Initialize banner list with your drawable resources
        bannerList = new ArrayList<>();
        bannerList.add(R.drawable.banner1);
        bannerList.add(R.drawable.banner2);
        bannerList.add(R.drawable.banner3);
        bannerList.add(R.drawable.banner4);
        bannerList.add(R.drawable.banner5);
        bannerList.add(R.drawable.banner6);
        // Add more banners as needed

        // Set up banners
        setupBanners();

        // Start auto-scroll if more than one banner
        if (bannerList.size() > 1) {
            startAutoScroll();
        }
    }

    private void setupBanners() {
        home_corosuel.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int bannerRes : bannerList) {
            View bannerView = inflater.inflate(R.layout.corousel_item, home_corosuel, false);
            ImageView imageView = bannerView.findViewById(R.id.banner_image);

            // Load image with Glide from drawable resource
            Glide.with(this)
                    .load(bannerRes)
                    .centerCrop()
                    .into(imageView);

            home_corosuel.addView(bannerView);
        }
    }

    private void startAutoScroll() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bannerList.size() > 1) {
                    currentPosition++;
                    if (currentPosition >= bannerList.size()) {
                        currentPosition = 0;
                    }

                    // Scroll to next banner
                    if (currentPosition < home_corosuel.getChildCount()) {
                        View childView = home_corosuel.getChildAt(currentPosition);
                        int scrollX = childView.getLeft();
                        home_horizontal_scroll.smoothScrollTo(scrollX, 0);
                    }

                    // Schedule next scroll
                    handler.postDelayed(this, 1500);
                }
            }
        }, 1500);
    }
}