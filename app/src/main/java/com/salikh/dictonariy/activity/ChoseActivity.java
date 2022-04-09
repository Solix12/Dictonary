package com.salikh.dictonariy.activity;

import android.content.Intent;
import android.os.Bundle;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.databinding.ActivityChoseBinding;

public class ChoseActivity extends BaseData {

    private ActivityChoseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChoseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setBars();
        setListeners();

    }

    private void setListeners() {
        binding.EngToUzb.setOnClickListener(view -> {
            Intent intent = new Intent(ChoseActivity.this, EngToUzbActivity.class);
            startActivity(intent);
        });

    }


    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {
        binding.EngToUzb.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        binding.imageView.setImageResource(MemoryHelper.getHelpr().getIcon());
        binding.container.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }
}