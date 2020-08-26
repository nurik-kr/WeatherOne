package com.example.weather.Forecast

data class ForecastItem(
    val dt: Int,
    val visibility: Int,
    val pop: Double,
    val dt_txt: String,
    val main: ForecastMain
)