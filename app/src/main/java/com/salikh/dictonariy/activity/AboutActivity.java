package com.salikh.dictonariy.activity;

import android.os.Bundle;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.databinding.ActivityAboutBinding;

public class AboutActivity extends BaseData {

    ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setBars();

    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {
        binding.malum.setTextColor(MemoryHelper.getHelpr().getTextColor());
        binding.textView2.setTextColor(MemoryHelper.getHelpr().getBackColor());
        binding.logo.setImageResource(MemoryHelper.getHelpr().getLogo());
        binding.text5.setTextColor(MemoryHelper.getHelpr().getTextColor());
        binding.container.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());

    }
}