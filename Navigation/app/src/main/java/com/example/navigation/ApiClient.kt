package com.example.navigation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val API_KEY = "e350cea260be5675e2ce52ab7ed5ae64"
    private const val API_URL = "$BASE_URL/discover/movie?sort_by=popularity.desc&page=1&api_key=$API_KEY"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}