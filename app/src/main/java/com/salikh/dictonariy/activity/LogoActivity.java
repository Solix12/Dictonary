package com.salikh.dictonariy.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.databinding.ActivityLogoBinding;

public class LogoActivity extends BaseData {

    private ActivityLogoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, ChoseActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

        setBars();
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }


    @Override
    public void setThemeData() {
        binding.imageIcon.setImageResource(MemoryHelper.getHelpr().getIcon());
        binding.textView.setTextColor(MemoryHelper.getHelpr().getTextColor());
        binding.textView2.setTextColor(MemoryHelper.getHelpr().getBackColor());
        binding.progresBar.setIndeterminateTintList(ColorStateList.valueOf(MemoryHelper.getHelpr().getBackColor()));
    }
}