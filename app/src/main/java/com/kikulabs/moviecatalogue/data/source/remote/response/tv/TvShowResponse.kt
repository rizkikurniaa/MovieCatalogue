package com.kikulabs.moviecatalogue.data.source.remote.response.tv

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvShowList>,

	@field:SerializedName("total_results")
	val totalResults: Int
)
