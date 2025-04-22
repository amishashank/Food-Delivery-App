package com.andro.myfoodz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andro.myfoodz.bottomnavs.HomeFragment;
import com.andro.myfoodz.bottomnavs.ProfileFragment;
import com.andro.myfoodz.bottomnavs.SearchFragment;
import com.andro.myfoodz.bottomnavs.CartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    // Bottom Navigation
    private BottomNavigationView bottom_nav_bar;
    private FrameLayout home_fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        bottomnavbar();
    }

    private void bottomnavbar() {
        bottom_nav_bar = findViewById(R.id.bottom_nav_bar);
        home_fragment_container = findViewById(R.id.home_fragment_container);
        Fragment home = new HomeFragment();
        Fragment search = new SearchFragment();
        Fragment profile = new ProfileFragment();
        Fragment cart = new CartFragment();

        setCurrentFragment(home);

        bottom_nav_bar.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                setCurrentFragment(home);
                return true;
            } else if (id == R.id.nav_search) {
                setCurrentFragment(search);
                return true;
            } else if (id == R.id.nav_cart) {
                setCurrentFragment(cart);
                return true;
            } else if (id == R.id.nav_profile) {
                setCurrentFragment(profile);
                return true;
            }

            return false;
        });



    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_fragment_container, fragment)
                .commit();
    }


}


