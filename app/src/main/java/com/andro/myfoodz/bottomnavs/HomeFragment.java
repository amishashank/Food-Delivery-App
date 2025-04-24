package com.andro.myfoodz.bottomnavs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andro.myfoodz.CorouselAdapter;
import com.andro.myfoodz.CorouselModel;
import com.andro.myfoodz.FoodDesc;
import com.andro.myfoodz.FoodMenu;
import com.andro.myfoodz.MenuAdapter;
import com.andro.myfoodz.MenuModel;
import com.andro.myfoodz.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FoodMenu foodMenu;
private Button view_menu_button;
    // Carousel
    private RecyclerView home_corosuel;
    private CorouselAdapter corouselAdapter;
    private List<CorouselModel> corouselModelList;
    private int currentPosition = 0;
    private Handler handler;
    private Runnable autoScrollRunnable;

    // Dots
    private LinearLayout carousel_dots;

    // Menu
    private RecyclerView home_menu_rv;
    private MenuAdapter menuAdapter;
    private List<MenuModel> menuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view_menu_button = view.findViewById(R.id.view_menu_button);
        view_menu_button.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FoodDesc.class);
                    Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_SHORT).show();
            startActivity(intent);
                });

        showcorousel(view);
        setupDots(view, 9);
        updateDotIndicator(0);
        autoScroll();
        foodMenu(view);

        return view;
    }

    private void showcorousel(View view) {
        home_corosuel = view.findViewById(R.id.home_carousel);
        home_corosuel.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        corouselModelList = new ArrayList<>();
        corouselModelList.add(new CorouselModel(R.drawable.banner1));
        corouselModelList.add(new CorouselModel(R.drawable.banner2));
        corouselModelList.add(new CorouselModel(R.drawable.banner3));
        corouselModelList.add(new CorouselModel(R.drawable.banner4));
        corouselModelList.add(new CorouselModel(R.drawable.banner5));
        corouselModelList.add(new CorouselModel(R.drawable.banner6));
        corouselModelList.add(new CorouselModel(R.drawable.banner7));
        corouselModelList.add(new CorouselModel(R.drawable.banner8));
        corouselModelList.add(new CorouselModel(R.drawable.banner9));

        corouselAdapter = new CorouselAdapter(corouselModelList);
        home_corosuel.setAdapter(corouselAdapter);
    }

    private void setupDots(View view, int size) {
        carousel_dots = view.findViewById(R.id.carousel_dots);
        carousel_dots.removeAllViews();

        for (int i = 0; i < size; i++) {
            ImageView dot = new ImageView(getContext());
            dot.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0);
            dot.setLayoutParams(params);

            carousel_dots.addView(dot);
        }
    }



    private void updateDotIndicator(int index) {
        if (getContext() == null) return;

        for (int i = 0; i < carousel_dots.getChildCount(); i++) {
            ImageView dot = (ImageView) carousel_dots.getChildAt(i);
            dot.setImageDrawable(ContextCompat.getDrawable(
                    requireContext(), i == index ? R.drawable.active_dot : R.drawable.non_active_dot));
        }
    }

    private void autoScroll() {
        handler = new Handler(Looper.getMainLooper());
        autoScrollRunnable = () -> {
            if (currentPosition == corouselModelList.size()) {
                currentPosition = 0;
            }
            home_corosuel.smoothScrollToPosition(currentPosition);
            updateDotIndicator(currentPosition);
            currentPosition++;
            handler.postDelayed(autoScrollRunnable, 2000);
        };
        handler.postDelayed(autoScrollRunnable, 2000);
    }

    private void foodMenu(View view) {
        home_menu_rv = view.findViewById(R.id.home_menu_rv);
        home_menu_rv.setLayoutManager(new LinearLayoutManager(getContext()));

        foodMenu = new FoodMenu();
        menuList = foodMenu.menuList;

        menuAdapter = new MenuAdapter(menuList);
        home_menu_rv.setAdapter(menuAdapter);
    }

}
