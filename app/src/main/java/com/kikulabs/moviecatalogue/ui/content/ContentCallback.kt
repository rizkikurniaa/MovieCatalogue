package com.kikulabs.moviecatalogue.ui.content

import com.kikulabs.moviecatalogue.data.DataEntity

interface ContentCallback {
    fun onItemClicked(data: DataEntity)
}