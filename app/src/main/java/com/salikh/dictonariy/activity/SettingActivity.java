package com.salikh.dictonariy.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;

public class SettingActivity extends BaseData {

    private ImageView red, yellow, blue;
    private ConstraintLayout layout;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        loadView();
        setListeners();
        setBars();
    }

    private void setListeners() {
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemoryHelper.getHelpr().setTextColor(Color.parseColor("#CB4335"));
                MemoryHelper.getHelpr().setBackColor(Color.parseColor("#F1948A"));
                MemoryHelper.getHelpr().setIcon(R.drawable.ic_red_icon);
                MemoryHelper.getHelpr().setLogo(R.drawable.ic_red_logo);
                MemoryHelper.getHelpr().setFavor(R.drawable.ic_red_bookmark);
                MemoryHelper.getHelpr().setDelete(R.drawable.ic_red_delete);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_red_interests);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_red_settings);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_red_support);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_red_info);
                MemoryHelper.getHelpr().setTelegram(R.drawable.ic_red_telegram);
                MemoryHelper.getHelpr().setInstagram(R.drawable.ic_red_instagram);
                MemoryHelper.getHelpr().setEmail(R.drawable.ic_red_email);
                MemoryHelper.getHelpr().setFavorBord(R.drawable.ic_red_bookmark_border);

                Toast.makeText(SettingActivity.this, "Theme changed", Toast.LENGTH_SHORT).show();
                setThemeData();
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemoryHelper.getHelpr().setTextColor(Color.parseColor("#D4AC0D"));
                MemoryHelper.getHelpr().setBackColor(Color.parseColor("#F4D03F"));
                MemoryHelper.getHelpr().setIcon(R.drawable.ic_yellow_icon);
                MemoryHelper.getHelpr().setLogo(R.drawable.ic_yellow_logo);
                MemoryHelper.getHelpr().setFavor(R.drawable.ic_yellow_bookmark);
                MemoryHelper.getHelpr().setDelete(R.drawable.ic_yellow_delete);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_yellow_interests);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_yellow_settings);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_yellow_support);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_yellow_info);
                MemoryHelper.getHelpr().setTelegram(R.drawable.ic_yellow_telegram);
                MemoryHelper.getHelpr().setInstagram(R.drawable.ic_yellow_instagram);
                MemoryHelper.getHelpr().setEmail(R.drawable.ic_yellow_email);
                MemoryHelper.getHelpr().setFavorBord(R.drawable.ic_yellow_bookmark_border);

                Toast.makeText(SettingActivity.this, "Theme changed", Toast.LENGTH_SHORT).show();
                setThemeData();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemoryHelper.getHelpr().setTextColor(Color.parseColor("#428782"));
                MemoryHelper.getHelpr().setBackColor(Color.parseColor("#5cbeb4"));
                MemoryHelper.getHelpr().setIcon(R.drawable.ic_blue_icon);
                MemoryHelper.getHelpr().setLogo(R.drawable.ic_blue_logo);
                MemoryHelper.getHelpr().setFavor(R.drawable.ic_blue_bookmark);
                MemoryHelper.getHelpr().setDelete(R.drawable.ic_blue_delete);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_blue_interests);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_blue_settings);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_blue_support);
                MemoryHelper.getHelpr().setInter(R.drawable.ic_blue_info);
                MemoryHelper.getHelpr().setTelegram(R.drawable.ic_blue_telegram);
                MemoryHelper.getHelpr().setInstagram(R.drawable.ic_blue_instagram);
                MemoryHelper.getHelpr().setEmail(R.drawable.ic_blue_email);
                MemoryHelper.getHelpr().setFavorBord(R.drawable.ic_blue_bookmark_border);

                Toast.makeText(SettingActivity.this, "Theme changed", Toast.LENGTH_SHORT).show();
                setThemeData();
            }
        });
    }


    private void loadView() {
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        blue = findViewById(R.id.defaut);
        layout = findViewById(R.id.container);
        textView4 = findViewById(R.id.textView4);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingActivity.this, EngToUzbActivity.class));
        super.onBackPressed();
    }


    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {

        layout.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        textView4.setTextColor(MemoryHelper.getHelpr().getTextColor());

        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }
}