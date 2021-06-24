package com.kikulabs.moviecatalogue.ui.content.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kikulabs.moviecatalogue.BuildConfig.IMAGE_URL
import com.kikulabs.moviecatalogue.R
import com.kikulabs.moviecatalogue.data.source.local.entity.TvShowEntity
import com.kikulabs.moviecatalogue.databinding.ItemsContentBinding
import com.kikulabs.moviecatalogue.ui.content.ContentCallback
import com.kikulabs.moviecatalogue.utils.DateChange

class TvShowAdapter: PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private lateinit var onItemClicked: ContentCallback

    fun setOnItemClicked(onItemClicked: ContentCallback) {
        this.onItemClicked = onItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(
            itemsTvShowBinding
        )
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val dateChange = DateChange()

        fun bind(tvShows: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShows.name
                tvReleaseDate.text = dateChange.changeFormatDate(tvShows.releaseDate)
                tvRating.text = tvShows.voteAverage.toString()
                tvOverviewValue.text = tvShows.overview

                Glide.with(itemView.context)
                    .asBitmap()
                    .load(IMAGE_URL + tvShows.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPoster)

                cvOverview.setOnClickListener {
                    onItemClicked.onItemClicked(tvShows.id.toString())
                }
            }
        }
    }
}