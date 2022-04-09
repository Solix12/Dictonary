package com.salikh.dictonariy.base;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseData extends AppCompatActivity {

    @Override
    protected void onResume() {
        setThemeData();
        super.onResume();
    }

    public abstract void setThemeData();
}
