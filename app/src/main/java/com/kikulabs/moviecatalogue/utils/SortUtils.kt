package com.kikulabs.moviecatalogue.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {

    const val BEST_RATE = "Best"
    const val WORST_RATE = "Worst"
    const val RANDOM = "Random"
    const val MOVIE_ENTITIES = "movie_entities"
    const val TV_SHOW_ENTITIES = "tv_show_entities"

    fun getSortedQuery(filter: String, table_name: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $table_name ")
        when (filter) {
            BEST_RATE -> simpleQuery.append("ORDER BY voteAverage DESC")
            WORST_RATE -> simpleQuery.append("ORDER BY voteAverage ASC")
            RANDOM -> simpleQuery.append("ORDER BY RANDOM()")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

}