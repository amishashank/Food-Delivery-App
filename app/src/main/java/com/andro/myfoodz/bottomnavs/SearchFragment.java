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

import com.andro.myfoodz.FoodMenu;
import com.andro.myfoodz.MenuAdapter;
import com.andro.myfoodz.MenuModel;
import com.andro.myfoodz.R;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    FoodMenu foodMenu;
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

        foodMenu = new FoodMenu();
        menuList = foodMenu.menuList;  // FIX: assign the data to the class-level list

        adapter = new MenuAdapter(menuList); // Now menuList isn't null
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
