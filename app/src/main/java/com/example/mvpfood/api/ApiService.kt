package com.example.mvpfood.api

import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("getMakanan")
    fun getfood(): Call<ResponseGetFood>


    @FormUrlEncoded
    @POST("insertMakanan")
    fun InsertDataFood(
        @Field("name") nameFood: String,
        @Field("price") priceFood: String,
        @Field("gambar") imgFood: String
    ): Call<ResponseGetFood>


    @FormUrlEncoded
    @POST("updateMakanan")
    fun updateFood(
        @Field("id") idFood: String,
        @Field("name") nameFood: String,
        @Field("price") priceFood: String,
        @Field("gambar") imgFood: String
    ): Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("deleteMakanan")
    fun deleteFood(
        @Field("id") idFood: String,
    ): Call<ResponseGetFood>

}