package com.example.movies

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class MoviesAdapter (private var movieList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieImage: ShapeableImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)

    }

    fun updateData(newMovies: List<Movie>) {
        movieList = newMovies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MyViewHolder, position: Int) {
        val currentItem = movieList[position]
        val imageBase = "https://image.tmdb.org/t/p/w500/"

        Glide.with(holder.itemView).load(imageBase + currentItem.posterPath).into(holder.movieImage)
        holder.movieTitle.text = currentItem.title
    }

    override fun getItemCount(): Int = movieList.size
}