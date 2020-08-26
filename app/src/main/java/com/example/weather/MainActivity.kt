package com.example.weather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.Forecast.ForecastModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val adapter = RvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter

        btnGo.setOnClickListener {
            forecastWeather(etCity.text.toString())
        }
    }
        private fun forecastWeather(city: String) {
            RetrofitBuilder.getService()?.getWeather(city, getString(R.string.api_key), "metric")
                ?.enqueue(object : Callback<ForecastModel> {

                    override fun onResponse(
                        call: Call<ForecastModel>,
                        response: Response<ForecastModel>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            adapter.update(response.body()?.list)
                        }
                    }

                    override fun onFailure(call: Call<ForecastModel>, t: Throwable) {
                        Log.d("adasdasd", "asdsadasdasd")
                    }

                })
        }
    }




