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
import com.salikh.dictonariy.adapters.DeleteAdapter;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class DeletesActivity extends BaseData {


    private static TextView textView;
    private static ArrayList<WordEngData> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private ConstraintLayout constraintLayout2;
    private DeleteAdapter adapter;
    private ImageButton buttonDel;

    public static void setVis() {
        textView.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletes);

        loadView();
        adapter = new DeleteAdapter(data);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);


        loadData();
        setBars();
        setListeners();
    }

    private void setListeners() {

        buttonDel.setOnClickListener(view -> {
            DataBase.getDataBase().deleteWordsDelete();
            adapter.clearData();
            textView.setVisibility(View.VISIBLE);
        });

    }

    private void loadData() {

        data = DataBase.getDataBase().getWordsDelete();
        adapter.setData(data);

    }

    private void loadView() {
        buttonDel = findViewById(R.id.allDelete);
        recyclerView = findViewById(R.id.recycleViewDel);
        constraintLayout2 = findViewById(R.id.constraintLayout2);
        textView = findViewById(R.id.noWordsDel);
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }


    @Override
    public void setThemeData() {
        constraintLayout2.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }

}