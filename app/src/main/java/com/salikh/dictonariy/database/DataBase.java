package com.salikh.dictonariy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.annotation.Nullable;

import com.salikh.dictonariy.lib.DbHelper;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class DataBase extends DbHelper {


    private static DataBase dataBase;

    private DataBase(@Nullable Context context) {
        super(context, "uzen.db");
    }

    public static DataBase getDataBase() {
        return dataBase;
    }

    public static void init(Context context) {
        if (dataBase == null) {
            dataBase = new DataBase(context);
        }
    }

    public ArrayList<WordEngData> getWords() {
        ArrayList<WordEngData> list = new ArrayList<>();

        String query = "SELECT * FROM collection";

        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            String eng = cursor.getString(0);
            String uzb = cursor.getString(1);
            WordEngData data = new WordEngData(eng, uzb);
            list.add(data);

            cursor.moveToNext();
        }

        return list;
    }


    public void insertWord(String eng, String uzb) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("Sen0", eng);
        contentValues.put("Sen1", uzb);

        mDataBase.insert("collection", null, contentValues);

    }


    public ArrayList<WordEngData> searchWordByName(String text) {
        ArrayList<WordEngData> students = new ArrayList<>();
        String query = "SELECT * FROM collection WHERE Sen0 LIKE '" + text + "%'";
        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String eng = cursor.getString(0);
            String uzb = cursor.getString(1);
            WordEngData data = new WordEngData(eng, uzb);
            students.add(data);
            cursor.moveToNext();
        }
        return students;
    }

    public int deleteWordInter(WordEngData word) {
        int id = word.getId();
        Log.e("TAGaaa", String.valueOf(id));
        return mDataBase.delete("forinteresting", "id=" + id, null);
    }


    public ArrayList<WordEngData> getWordsInter() {
        ArrayList<WordEngData> list = new ArrayList<>();

        String query = "SELECT * FROM forinteresting";

        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            String eng = cursor.getString(1);
            String uzb = cursor.getString(2);
            int id = cursor.getInt(0);
            WordEngData data = new WordEngData(eng, uzb, id);
            list.add(data);

            cursor.moveToNext();
        }

        return list;
    }


    public void insertWordInter(String eng, String uzb) {

        ContentValues contentValues = new ContentValues();


        contentValues.put("interEng", eng);
        contentValues.put("interUzb", uzb);

        mDataBase.insert("forinteresting", null, contentValues);

    }


    public ArrayList<WordEngData> getWordsDelete() {
        ArrayList<WordEngData> list = new ArrayList<>();

        String query = "SELECT * FROM deletes";

        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            String eng = cursor.getString(1);
            String uzb = cursor.getString(2);
            int id = cursor.getInt(0);
            WordEngData data = new WordEngData(eng, uzb, id);
            list.add(data);

            cursor.moveToNext();
        }

        return list;
    }


    public void insertWordDelete(String eng, String uzb) {

        ContentValues contentValues = new ContentValues();


        contentValues.put("delEng", eng);
        contentValues.put("delUzb", uzb);

        mDataBase.insert("deletes", null, contentValues);

    }

    public void deleteWordsDelete() {

        String query = "DELETE FROM deletes WHERE id>0 ";
        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();

    }


    public ArrayList<WordEngData> getWordsFavouritiy() {
        ArrayList<WordEngData> list = new ArrayList<>();

        String query = "SELECT * FROM favoriti";

        Cursor cursor = mDataBase.rawQuery(query, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            String eng = cursor.getString(1);
            String uzb = cursor.getString(2);
            int id = cursor.getInt(0);
            WordEngData data = new WordEngData(eng, uzb, id);
            list.add(data);

            cursor.moveToNext();
        }

        return list;
    }

    public int deleteWordFavouritiy(int id) {
        Log.e("TAGaaa", String.valueOf(id));
        return mDataBase.delete("favoriti", "id=" + id, null);
    }

    public void insertWordFavouritiy(String eng, String uzb) {

        ContentValues contentValues = new ContentValues();


        contentValues.put("fovEng", eng);
        contentValues.put("fovUzb", uzb);

        mDataBase.insert("favoriti", null, contentValues);

    }


}
