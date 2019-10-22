package com.example.myandroidlearning.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myandroidlearning.HelpItem;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void setSharedPreferences(Context context,String sharedPrefName){

        this.sharedPreferences=context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        this.editor=this.sharedPreferences.edit();
    }

    public void putList(String key, List<String> value){
        Set<String> data=new HashSet<String>();

        for (String val : value) {
            data.add(val);
        }
        if (data != null) {
            editor.putStringSet(key,data);
            editor.apply();
        }


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

    public  HashSet<String> getDataObject(String key){
        Set<String> emptySet=new HashSet<String>();
        Set<String> data= sharedPreferences.getStringSet(key,emptySet);
        return new HashSet<>(data);
    }
}
