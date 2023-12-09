package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.RetrofitClient.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerview: RecyclerView
    private var movies: List<Movie> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecyclerview = findViewById(R.id.moviesList)
        newRecyclerview.layoutManager = GridLayoutManager(this, 3)
        newRecyclerview.hasFixedSize()
        getMovieData(1)
    }

    private fun getMovieData(page: Int) {
        val call = ApiClient.apiService.getMovies(page)

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    val newMovies = movieResponse?.results ?: emptyList()

                    movies = (movies + newMovies)
                    //(newRecyclerview.adapter as? MoviesAdapter)?.updateData(movies)
                    newRecyclerview.adapter = MoviesAdapter(movies)

                    //if (page < (movieResponse?.totalPages ?: 0)) {
                    if (page < 15 ) {
                        getMovieData(page + 1)
                    }
                } else {
                    Log.e("Error", "Error: ${response.code()}, Message: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("Error", "Failed to fetch data", t)
            }
        })
    }
}

