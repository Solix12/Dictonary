package com.salikh.dictonariy.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.base.BaseData;
import com.salikh.dictonariy.cache.MemoryHelper;

public class SupportActivity extends BaseData {

    private LinearLayout telegramBtn, instaBtn, emailBtn, lina, lna1, lnn2, lna3;
    private ImageView telegramImage, instaImage, emailImage, logo;
    private TextView telegramText, instaText, emailText, malum, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        loadView();
        setListeners();
        setBars();
    }

    private void setListeners() {
        telegramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://t.me/Muhammadsolih_Abdugafforov");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
        instaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/salikh_444");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void loadView() {
        telegramBtn = findViewById(R.id.telegram);
        instaBtn = findViewById(R.id.instagram);
        emailBtn = findViewById(R.id.email);

        telegramImage = findViewById(R.id.telegram_image);
        instaImage = findViewById(R.id.instagram_image);
        emailImage = findViewById(R.id.email_image);

        telegramText = findViewById(R.id.telegram_text);
        instaText = findViewById(R.id.instagram_text);
        emailText = findViewById(R.id.email_text);
        contact = findViewById(R.id.contactUs);
        malum = findViewById(R.id.malum);
        logo = findViewById(R.id.logo);

        lina = findViewById(R.id.lina);
        lna1 = findViewById(R.id.lina1);
        lnn2 = findViewById(R.id.lina2);
        lna3 = findViewById(R.id.lina3);
    }

    private void setBars() {
        getWindow().setNavigationBarColor(getResources().getColor(R.color.blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
    }

    @Override
    public void setThemeData() {
        telegramImage.setImageResource(MemoryHelper.getHelpr().getTelegram());
        instaImage.setImageResource(MemoryHelper.getHelpr().getInstagram());
        emailImage.setImageResource(MemoryHelper.getHelpr().getEmail());
        logo.setImageResource(MemoryHelper.getHelpr().getIcon());

        telegramText.setTextColor(MemoryHelper.getHelpr().getTextColor());
        instaText.setTextColor(MemoryHelper.getHelpr().getTextColor());
        emailText.setTextColor(MemoryHelper.getHelpr().getTextColor());
        malum.setTextColor(MemoryHelper.getHelpr().getTextColor());
        contact.setTextColor(MemoryHelper.getHelpr().getTextColor());
        lina.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        lna1.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        lnn2.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        lna3.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());


        getWindow().setNavigationBarColor(MemoryHelper.getHelpr().getBackColor());
        getWindow().setStatusBarColor(MemoryHelper.getHelpr().getBackColor());
    }
}