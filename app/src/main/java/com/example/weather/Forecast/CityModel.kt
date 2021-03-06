package com.example.weather.Forecast

import Coord

data class CityModel(
    val id: Int,
    val name: String,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int,
    val coord: Coorde
)
