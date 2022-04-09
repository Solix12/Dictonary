package com.salikh.dictonariy.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.salikh.dictonariy.R;

public class MemoryHelper {


    private static MemoryHelper helper;
    private final SharedPreferences preferences;


    private MemoryHelper(Context context) {
        preferences = context.getSharedPreferences("calc", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {

        if (helper == null) {
            helper = new MemoryHelper(context);
        }
    }

    public static MemoryHelper getHelpr() {
        return helper;
    }

    public int getBackColor() {

        return preferences.getInt("theme_back", Color.parseColor("#5cbeb4"));

    }

    // mainBackColor
    public void setBackColor(int themeId) {

        preferences.edit().putInt("theme_back", themeId).apply();

    }

    public int getTextColor() {

        return preferences.getInt("theme_tex", Color.parseColor("#428782"));

    }

    //textColor
    public void setTextColor(int themeId) {

        preferences.edit().putInt("theme_tex", themeId).apply();

    }

    public int getIcon() {

        return preferences.getInt("theme_icon", R.drawable.ic_blue_icon);

    }

    //icon
    public void setIcon(int themeId) {

        preferences.edit().putInt("theme_icon", themeId).apply();

    }

    public int getLogo() {

        return preferences.getInt("theme_logo", R.drawable.ic_blue_logo);

    }

    //logo
    public void setLogo(int themeId) {

        preferences.edit().putInt("theme_logo", themeId).apply();

    }

    public int getFavor() {

        return preferences.getInt("theme_favor", R.drawable.ic_blue_bookmark);

    }

    //favor
    public void setFavor(int themeId) {

        preferences.edit().putInt("theme_favor", themeId).apply();

    }

    public int getFavorBord() {

        return preferences.getInt("theme_favorBord", R.drawable.ic_blue_bookmark_border);

    }

    //favorBord
    public void setFavorBord(int themeId) {

        preferences.edit().putInt("theme_favorBord", themeId).apply();

    }

    public int getDelete() {

        return preferences.getInt("theme_delete", R.drawable.ic_blue_delete);

    }

    //delete
    public void setDelete(int themeId) {

        preferences.edit().putInt("theme_delete", themeId).apply();

    }

    public int getInter() {

        return preferences.getInt("theme_inter", R.drawable.ic_blue_interests);

    }

    //interests
    public void setInter(int themeId) {

        preferences.edit().putInt("theme_inter", themeId).apply();

    }

    public int getSetting() {

        return preferences.getInt("theme_setting", R.drawable.ic_blue_settings);

    }

    //setting
    public void setSetting(int themeId) {

        preferences.edit().putInt("theme_setting", themeId).apply();

    }

    public int getSupport() {

        return preferences.getInt("theme_support", R.drawable.ic_blue_support);

    }

    //support
    public void setSupport(int themeId) {

        preferences.edit().putInt("theme_support", themeId).apply();

    }

    public int getAbout() {

        return preferences.getInt("theme_about", R.drawable.ic_blue_info);

    }

    //about
    public void setAbout(int themeId) {

        preferences.edit().putInt("theme_about", themeId).apply();

    }

    public int getTelegram() {

        return preferences.getInt("theme_telegram", R.drawable.ic_blue_telegram);

    }

    //telegram
    public void setTelegram(int themeId) {

        preferences.edit().putInt("theme_telegram", themeId).apply();

    }

    public int getInstagram() {

        return preferences.getInt("theme_insta", R.drawable.ic_blue_instagram);

    }

    //instagram
    public void setInstagram(int themeId) {

        preferences.edit().putInt("theme_insta", themeId).apply();

    }

    public int getEmail() {

        return preferences.getInt("theme_email", R.drawable.ic_blue_email);

    }

    //email
    public void setEmail(int themeId) {

        preferences.edit().putInt("theme_email", themeId).apply();

    }


}
