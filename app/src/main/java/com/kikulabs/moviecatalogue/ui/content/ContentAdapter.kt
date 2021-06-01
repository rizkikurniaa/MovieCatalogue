package com.kikulabs.moviecatalogue.ui.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.BuildConfig.IMAGE_URL
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.source.local.entity.DataEntity
import com.kikulabs.moviecatalogue.databinding.ItemsContentBinding
import com.kikulabs.moviecatalogue.utils.DateChange

class ContentAdapter(private val callback: ContentCallback) :
    RecyclerView.Adapter<ContentAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<DataEntity>()

    fun setMovies(data: List<DataEntity>?) {
        if (data == null) return
        this.listMovies.clear()
        this.listMovies.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(
            itemsMovieBinding
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemsContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val dateChange = DateChange()

        fun bind(movies: DataEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvReleaseDate.text = dateChange.changeFormatDate(movies.releaseDate)
                tvRating.text = movies.rating.toString()
                tvOverviewValue.text = movies.overview

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                cvOverview.setOnClickListener {
                    callback.onItemClicked(movies)
                }
            }
        }
    }
}