package com.example.dogspath.activity.activity.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrence {
    private static SharedPrefrence Prefrence;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefsEditor;

    public static SharedPrefrence getInstance(Context context) {
        if (Prefrence == null) {
            Prefrence = new SharedPrefrence(context);
        }
        return Prefrence;
    }

    private SharedPrefrence(Context context) {
        sharedPreferences = context.getSharedPreferences("EShop",Context.MODE_PRIVATE);
    }

    public void saveData(String key,String value) {
        prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public String getData(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public void clear(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }

}
