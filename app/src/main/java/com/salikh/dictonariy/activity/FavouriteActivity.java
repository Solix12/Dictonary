package com.salikh.dictonariy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.adapters.SwipeAdapterFav;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class FavouriteActivity extends BaseData {

    private static TextView textView;
    private static ArrayList<WordEngData> data = new ArrayList<>();
    private RecyclerView rcyclerView;
    private ConstraintLayout constraintLayout3;
    private ImageButton button;
    private SwipeAdapterFav adapter;

    public static void chekViziblFav() {
        if (data.size() == 0) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        loadView();
        adapter = new SwipeAdapterFav(this, data);
        rcyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rcyclerView.setLayoutManager(linearLayoutManager);

        loadData();
        setBars();
        setListeners();
        chekViziblFav();

    }

    private void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        data = DataBase.getDataBase().getWordsFavouritiy();
        adapter.setData(data);
    }

    private void loadView() {
        rcyclerView = findViewById(R.id.rcycle_viev_fav);
        button = findViewById(R.id.backBtn);
        textView = findViewById(R.id.noWordsFav);
        constraintLayout3 = findViewById(R.id.constraintLayout3);
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {
        constraintLayout3.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }
}