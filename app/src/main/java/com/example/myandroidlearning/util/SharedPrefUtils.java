package com.example.myandroidlearning.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myandroidlearning.HelpItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPrefUtils {

    Context context=ResourceUtil.getAppContext();
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

    public void saveLoginCredential(HashMap<String,String> details,String shared_pref_name){
        this.sharedPreferences=context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        this.editor=this.sharedPreferences.edit();

        editor.putString("username",details.get("username"));
        editor.putString("password",details.get("password"));
        editor.apply();
    }

    public HashMap<String,String> getLoginCredentials(String shared_pref_name){
        this.sharedPreferences=context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        this.editor=this.sharedPreferences.edit();
        HashMap<String,String> credential= new HashMap<>();
       credential.put("username",sharedPreferences.getString("username","")) ;
       credential.put("password",sharedPreferences.getString("password",""));
       return credential;

    }

    public void clearSharedPreference(String shared_pref_name){
        context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE).edit().clear().commit();
    }
}
