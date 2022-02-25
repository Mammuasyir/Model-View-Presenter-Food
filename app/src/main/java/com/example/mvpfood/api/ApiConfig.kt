package com.example.mvpfood.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {
    private fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.apply {
        logging.level = HttpLoggingInterceptor.Level.BODY
    }
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    private fun initGson() : Gson{
        return GsonBuilder().setLenient().create()
    }

    const val baseUrl = "https://crud-food.000webhostapp.com/index.php/Api/"

    var retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(initGson()))
        .client(getInterceptor())
        .build()
    var service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
}