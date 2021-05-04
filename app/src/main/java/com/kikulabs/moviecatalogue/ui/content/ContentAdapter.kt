package com.kikulabs.moviecatalogue.ui.content

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.DataEntity
import com.kikulabs.moviecatalogue.databinding.ItemsContentBinding
import com.kikulabs.moviecatalogue.ui.detail.DetailMovieActivity

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<DataEntity>()

    fun setMovies(data: List<DataEntity>?) {
        if (data == null) return
        this.listMovies.clear()
        this.listMovies.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(
            itemsMovieBinding
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val course = listMovies[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listMovies.size


    class MovieViewHolder(private val binding: ItemsContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: DataEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvReleaseDate.text = movies.releaseDate
                tvRating.text = movies.rating
                tvOverviewValue.text = movies.overview

                cvOverview.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.movieId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(ivPoster)
            }
        }
    }
}