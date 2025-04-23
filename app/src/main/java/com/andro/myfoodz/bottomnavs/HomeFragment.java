package com.andro.myfoodz.bottomnavs;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andro.myfoodz.CorouselAdapter;
import com.andro.myfoodz.CorouselModel;
import com.andro.myfoodz.MenuAdapter;
import com.andro.myfoodz.MenuModel;
import com.andro.myfoodz.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

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
        menuList = new ArrayList<>();

        menuList.add(new MenuModel(R.drawable.menu_pic1, "Banana Asharfi", "550"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Chai-Infused Emperor's Green Rice", "600"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Satpura with Chole and Chutney", "450"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Company Baug Laddoo", "400"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Dal Bukhara", "700"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Paneer Tikka Masala", "600"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Tandoori Broccoli", "450"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Mushroom & Water Chestnut Dim Sum", "650"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Gobi Manchurian", "550"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Hakka Noodles", "500"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Steamed Jasmine Rice", "300"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Black Pepper Tofu", "750"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Masala Chai", "200"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Classic Mango Lassi", "250"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Paneer Makhani", "650"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Vegetable Spring Rolls", "400"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Schezwan Paneer", "550"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Stuffed Kulcha", "350"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Quinoa Upma", "650"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Corn Bhajiya", "650"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Baked Nachos with Guacamole", "700"));
        menuList.add(new MenuModel(R.drawable.menu_pic1, "Rucola, Quinoa & Avocado Salad", "825"));
        menuList.add(new MenuModel(R.drawable.menu_pic, "Pizza Verdure", "900"));
        menuList.add(new MenuModel(R.drawable.menu_pic2, "Paneer Tikka Pizza", "950"));


        menuAdapter = new MenuAdapter(menuList);
        home_menu_rv.setAdapter(menuAdapter);
    }
}
