package com.kikulabs.moviecatalogue.ui.content.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.BuildConfig.IMAGE_URL
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.source.local.entity.MovieEntity
import com.kikulabs.moviecatalogue.databinding.ItemsContentBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.utils.DateChange

class MovieAdapter: PagedListAdapter<MovieEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClicked: ContentCallback

    fun setOnItemClicked(onItemClicked: ContentCallback) {
        this.onItemClicked = onItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding =
            ItemsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(
            itemsMovieBinding
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(private val binding: ItemsContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val dateChange = DateChange()

        fun bind(movies: MovieEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvReleaseDate.text = dateChange.changeFormatDate(movies.releaseDate)
                tvRating.text = movies.voteAverage.toString()
                tvOverviewValue.text = movies.overview

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + movies.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                cvOverview.setOnClickListener {
                    onItemClicked.onItemClicked(movies.id.toString())
                }
            }
        }
    }
}