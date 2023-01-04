package com.example.umc9

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lat") lan: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ): Call<WeatherResponse>
}
//
//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}