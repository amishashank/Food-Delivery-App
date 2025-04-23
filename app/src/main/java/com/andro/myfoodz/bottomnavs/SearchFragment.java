package com.andro.myfoodz.bottomnavs;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andro.myfoodz.MenuAdapter;
import com.andro.myfoodz.MenuModel;
import com.andro.myfoodz.R;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuModel> menuList;
    private SearchView searchView;
    private SearchBar searchBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView = view.findViewById(R.id.searchView);
        searchBar = view.findViewById(R.id.searchBar);
        recyclerView = view.findViewById(R.id.searchResult_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        // Dummy menu data
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

        adapter = new MenuAdapter(menuList);
        recyclerView.setAdapter(adapter);


        searchBar.setOnClickListener(v -> searchView.show());


        EditText searchEditText = searchView.getEditText();
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterResults(s.toString());
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        return view;
    }

    // Filter logic
    private void filterResults(String query) {
        List<MenuModel> filteredList = new ArrayList<>();
        for (MenuModel item : menuList) {
            if (item.getMenu_name().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}
