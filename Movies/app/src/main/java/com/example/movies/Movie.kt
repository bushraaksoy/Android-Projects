package com.example.movies

import com.google.gson.annotations.SerializedName

data class Movie(
//    @SerializedName("id")
//    val id: String?,
//    @SerializedName("original_title")
//    val originalTitle: String,
//    @SerializedName("overview")
//    val overview: String,
//    @SerializedName("release_date")
//    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("title")
    val title: String?
)