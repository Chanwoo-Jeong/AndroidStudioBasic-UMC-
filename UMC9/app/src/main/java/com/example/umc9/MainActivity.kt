package com.example.umc9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)

        apiService.getWeather("37.445293","126.785823","b1581c63833eb15d2ba7179d359626a0").enqueue(object :Callback<WeatherResponse>{

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    val WeatherResponse = response.body()
                    if (WeatherResponse != null) {
                        var weathermain = WeatherResponse.weather[0].main.toString()
                        var desc =WeatherResponse.weather[0].description.toString()

                        Log.d("mainactivity", "${weathermain} + ${desc}")
                    } else{
                        Log.d("main is ", "null")
                    }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("Retrofit","Error!",t)
            }
        })
    }
}
