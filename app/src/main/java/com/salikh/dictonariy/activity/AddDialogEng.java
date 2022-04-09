package com.salikh.dictonariy.activity;

import static com.salikh.dictonariy.activity.EngToUzbActivity.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.database.DataBase;

public class AddDialogEng extends Dialog {

    private EditText engWord, uzbWord;
    private Button button;

    public AddDialogEng(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_eng);

        loadView();
        setListeners();
    }

    private void setListeners() {


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eng = engWord.getText().toString();
                String uzb = uzbWord.getText().toString();
                DataBase.getDataBase().insertWord(eng, uzb);
                dialog.cancel();
                Log.e("TAGeng", engWord.getText().toString());
                Log.e("TAGeng", uzbWord.getText().toString());
            }
        });


    }

    private void loadView() {
        engWord = findViewById(R.id.engAdd_uz);
        uzbWord = findViewById(R.id.uzbAdd_uz);
        button = findViewById(R.id.add_btn);
    }

    @Override
    public void onBackPressed() {
        dialog.cancel();
        super.onBackPressed();
    }
}
