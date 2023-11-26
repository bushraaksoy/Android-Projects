package com.example.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigation.databinding.FragmentMoviesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesFragment : Fragment() {
    private lateinit var newRecyclerview: RecyclerView
    private var movies: List<Movie> = emptyList()
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val rootView = binding.root

        newRecyclerview = binding.moviesList
        newRecyclerview.layoutManager = GridLayoutManager(requireContext(), 3)
        newRecyclerview.setHasFixedSize(true)
        getMovieData(1)

        return rootView
    }

    private fun getMovieData(page: Int) {
        val call = ApiClient.apiService.getMovies(page)

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val movieResponse = response.body()
                    val newMovies = movieResponse?.results ?: emptyList()

                    movies = (movies + newMovies)
                    newRecyclerview.adapter = MoviesAdapter(movies)

                    if (page < 15) {
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
