package com.example.myandroidlearning.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {

    Context context;
    public static String SHARED_PREF_NAME="SharedRef";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public SharedPrefUtils(Context context) {
        this.sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

    }

    public SharedPrefUtils() {
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }



    public void setSharedPreferences(Context context){

        this.sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.editor=this.sharedPreferences.edit();
    }


    public void addString(String key,String value){
        setString(key, value);
    }

    public void setInt(String key,int value){
    editor.putInt(key, value);
    editor.apply();
    }

    public void setString(String key,String value){
        editor.putString(key, value);
        editor.apply();
    }

    public void setBoolean(String key,boolean value){
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setLong(String key,long value){
        editor.putLong(key, value);
    }

    public  String getString(String key){

       return sharedPreferences.getString(key,"Sorry data not available");

    }
}
