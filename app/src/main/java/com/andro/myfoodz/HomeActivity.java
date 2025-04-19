package com.andro.myfoodz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    // Carousel
    private RecyclerView home_corosuel;
    private CorouselAdapter corouselAdapter;
    private List<CorouselModel> corouselModelList;
    private int currentPosition = 0;
    private Handler handler;
    private Runnable autoScrollRunnable;

    // Menu
    private RecyclerView home_menu_rv;
    private MenuAdapter menuAdapter;
    private List<MenuModel> menuList;
    private ImageView menu_image;
    private  TextView menu_name;
    private TextView menu_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        //methdod used
        showcorousel();
        autoScroll();
        foodMenu();
    }


    // Carousel setup
    private void showcorousel() {
        home_corosuel = findViewById(R.id.home_corosuel);
        home_corosuel.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

// Sample banners
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
    private void autoScroll() {
        handler =new Handler(Looper.getMainLooper());
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                if (currentPosition == corouselModelList.size()) {
                    currentPosition = 0;
                }
                home_corosuel.smoothScrollToPosition(currentPosition++);
                handler.postDelayed(this, 1500);
            }
        };
        handler.postDelayed(autoScrollRunnable, 1500);
    }
    //foodMenu
    private void foodMenu() {
        home_menu_rv = findViewById(R.id.home_menu_rv);
        home_menu_rv.setLayoutManager(new LinearLayoutManager(this));
        menuList = new ArrayList<>();
//        menuList.add(new MenuModel("R.drawable.menu_pic", "Dal Bukhara", "700"));
//        menuList.add(new MenuModel("R.drawable.menu_pic1", "Paneer Tikka Masala", "600"));
//        menuList.add(new MenuModel("R.drawable.menu_pic2", "Tandoori Broccoli", "450"));
//        menuList.add(new MenuModel("R.drawable.menu_pic3", "Mushroom & Water Chestnut Dim Sum", "650"));
//        menuList.add(new MenuModel("R.drawable.menu_pic4", "Gobi Manchurian", "550"));
//        menuList.add(new MenuModel("R.drawable.menu_pic5", "Hakka Noodles", "500"));
//        menuList.add(new MenuModel("R.drawable.menu_pic6", "Steamed Jasmine Rice", "300"));
//        menuList.add(new MenuModel("R.drawable.menu_pic7", "Black Pepper Tofu", "750"));
//        menuList.add(new MenuModel("R.drawable.menu_pic8", "Masala Chai", "200"));
//        menuList.add(new MenuModel("R.drawable.menu_pic9", "Classic Mango Lassi", "250"));
//        menuList.add(new MenuModel("R.drawable.menu_pic10", "Paneer Makhani", "650"));
//        menuList.add(new MenuModel("R.drawable.menu_pic11", "Vegetable Spring Rolls", "400"));
//        menuList.add(new MenuModel("R.drawable.menu_pic12", "Schezwan Paneer", "550"));
//        menuList.add(new MenuModel("R.drawable.menu_pic13", "Stuffed Kulcha", "350"));
//        menuList.add(new MenuModel("R.drawable.menu_pic14", "Quinoa Upma", "650"));
//        menuList.add(new MenuModel("R.drawable.menu_pic15", "Corn Bhajiya", "650"));
//        menuList.add(new MenuModel("R.drawable.menu_pic16", "Baked Nachos with Guacamole", "700"));
//        menuList.add(new MenuModel("R.drawable.menu_pic17", "Rucola, Quinoa & Avocado Salad", "825"));
//        menuList.add(new MenuModel("R.drawable.menu_pic18", "Pizza Verdure", "900"));
//        menuList.add(new MenuModel("R.drawable.menu_pic19", "Paneer Tikka Pizza", "950"));

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
