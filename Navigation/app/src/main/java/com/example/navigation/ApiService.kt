package com.example.navigation

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie?sort_by=popularity.desc&api_key=e350cea260be5675e2ce52ab7ed5ae64")
    fun getMovies(@Query("page") page: Int): Call<MovieResponse>
}

data class MovieResponse(
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int
)
