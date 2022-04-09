package com.salikh.dictonariy.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.salikh.dictonariy.R;
import com.salikh.dictonariy.adapters.DeleteAdapter;
import com.salikh.dictonariy.adapters.SwipeAdapter;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class EngToUzbActivity extends BaseData {

    public static AddDialogEng dialog;
    ArrayList<WordEngData> engData;
    private DeleteAdapter adapter;
    private SwipeAdapter adapterS;
    private ConstraintLayout constraintLayout;
    private RecyclerView recyclerView;
    private EditText search;
    private FloatingActionButton button;
    private DrawerLayout drawerLayout;
    private NavigationView navigation;

    private View item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_to_uzb);

        adapterS = new SwipeAdapter(this, engData);
        loadViews();
        recyclerView.setAdapter(adapterS);

        setBars();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);

        loadData();

        setListeners();


        setNavigation();
        searchLoad();

    }

    private void searchLoad() {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (!editable.toString().trim().isEmpty()) {

                        adapterS.clearData();
                        ArrayList<WordEngData> data = DataBase.getDataBase().searchWordByName(editable.toString().trim());
                        adapterS.setData(data);

                    } else {

                        adapterS.clearData();
                        loadData();

                    }
                }
            }
        });
    }

    private void setNavigation() {
        navigation.setItemIconTintList(null);
        navigation.setItemTextColor(ColorStateList.valueOf(Color.parseColor("#428782")));
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.favoruty_item) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, FavouriteActivity.class);
                    startActivity(newIntent);
                } else if (id == R.id.delete) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, DeletesActivity.class);
                    startActivity(newIntent);
                } else if (id == R.id.inter) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, InterestActivity.class);
                    startActivity(newIntent);
                } else if (id == R.id.setting) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, SettingActivity.class);
                    startActivity(newIntent);
                    finish();
                } else if (id == R.id.support) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, SupportActivity.class);
                    startActivity(newIntent);
                } else if (id == R.id.about) {
                    Intent newIntent = new Intent(EngToUzbActivity.this, AboutActivity.class);
                    startActivity(newIntent);
                }
                return true;
            }
        });

    }


    private void setListeners() {

        button.setOnClickListener(view -> {

            dialog = new AddDialogEng(EngToUzbActivity.this);
            dialog.setCancelable(false);
            dialog.show();

        });

        findViewById(R.id.menu_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    private void loadData() {

        engData = DataBase.getDataBase().getWords();
        adapterS.setData(engData);

    }

    private void loadViews() {
        recyclerView = findViewById(R.id.word_list);
        button = findViewById(R.id.fload_btn);
        drawerLayout = findViewById(R.id.drav_leyaut);
        navigation = findViewById(R.id.navigation_bar);
        constraintLayout = findViewById(R.id.container);
        search = findViewById(R.id.search_text);
        item = findViewById(R.id.favoruty_item);
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {
        constraintLayout.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
        search.setHintTextColor(MemoryHelper.getHelpr().getTextColor());
        button.setBackgroundTintList(ColorStateList.valueOf(MemoryHelper.getHelpr().getBackColor()));
    }

}