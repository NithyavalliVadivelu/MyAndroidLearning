package com.example.myandroidlearning;

import com.example.myandroidlearning.Model.Main;
import com.example.myandroidlearning.Model.RetroPhoto;
import com.example.myandroidlearning.Model.WeatherDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetServices {

    @GET("/data/2.5/weather")
    Call<WeatherDetails> getWeatherDetailsBasedOnCityName(@Query("q") String q, @Query("appid") String appid);

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();


}
