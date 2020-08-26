package com.example.weather

import com.example.weather.Current.CurrentWeather
import com.example.weather.Forecast.ForecastItem
import com.example.weather.Forecast.ForecastModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/forecast")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): Call<ForecastModel>
}