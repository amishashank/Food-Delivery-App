package com.andro.myfoodz.bottomnavs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.andro.myfoodz.MenuAdapter;
import com.andro.myfoodz.MenuModel;
import com.andro.myfoodz.R;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private RecyclerView searchResult_rv;
    private AppBarLayout searchTopBarLayout;

    private MenuAdapter menuadapter;
    private List<MenuModel>searchlist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchResult_rv = view.findViewById(R.id.searchResult_rv);
        searchTopBarLayout = view.findViewById(R.id.searchTopBarLayout);

        buidRecyclerview();
        return view;
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//       MenuInflater inflater1 = getActivity().getMenuInflater();
//       inflater1.inflate();
//       super.onCreateOptionsMenu(menu, inflater);
//    }

    private void buidRecyclerview() {
        searchlist = new ArrayList<>();
        searchlist.add(new MenuModel(R.drawable.menu_pic1, "Banana Asharfi", "550"));
        searchlist.add(new MenuModel(R.drawable.menu_pic, "Chai-Infused Emperor's Green Rice", "600"));
        searchlist.add(new MenuModel(R.drawable.menu_pic2, "Satpura with Chole and Chutney", "450"));
        searchlist.add(new MenuModel(R.drawable.menu_pic1, "Company Baug Laddoo", "400"));


        menuadapter = new MenuAdapter(searchlist);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        searchResult_rv.setLayoutManager(manager);
        searchResult_rv.setAdapter(menuadapter);
    }


}