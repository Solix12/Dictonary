package com.salikh.dictonariy.app;

import android.app.Application;

import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataBase.init(this);
        MemoryHelper.init(this);
    }
}
