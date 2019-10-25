package com.example.myandroidlearning.providers;

import com.example.myandroidlearning.services.AccountProfileServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountProfileServiceProvider {

    private final static String BASE_URL = "https://fierce-falls-80748.herokuapp.com/";
    static Gson gson=new GsonBuilder().setLenient().create();

    public static Retrofit getRetroInstance(String URL){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Retrofit.Builder retrofitBuilder;
        Retrofit retrofit=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client).build();
        return retrofit;
    }

    public static AccountProfileServices getRetroInstance(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Retrofit.Builder retrofitBuilder;
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client).build();

        return retrofit.create(AccountProfileServices.class);
    }

    public static AccountProfileServices getServiceWithoutGsonConverter(){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Retrofit.Builder retrofitBuilder;
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client).build();

        return retrofit.create(AccountProfileServices.class);
    }
}
