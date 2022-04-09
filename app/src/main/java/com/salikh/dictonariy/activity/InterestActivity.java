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
import com.salikh.dictonariy.adapters.SwipeAdapterInter;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class InterestActivity extends BaseData {

    private static TextView textView;
    private static ArrayList<WordEngData> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private SwipeAdapterInter adapter;
    private ConstraintLayout layout;
    private ImageButton buttonBack;

    public static void chekVizibl() {
        if (data.size() == 0) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        loadView();
        adapter = new SwipeAdapterInter(this, data);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);


        data = DataBase.getDataBase().getWordsInter();
        adapter.setData(data);
        setBars();
        setListeners();
        chekVizibl();

    }

    private void setListeners() {
        buttonBack.setOnClickListener(view -> {
            finish();
        });
    }

    private void loadView() {
        recyclerView = findViewById(R.id.recycle_inter);
        layout = findViewById(R.id.constraintLayout);
        buttonBack = findViewById(R.id.btnBack);
        textView = findViewById(R.id.noWords);
    }

    @Override
    public void setThemeData() {
        layout.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }
}