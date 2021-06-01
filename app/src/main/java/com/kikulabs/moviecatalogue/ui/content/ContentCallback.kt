package com.kikulabs.moviecatalogue.ui.content

import com.kikulabs.moviecatalogue.data.source.local.entity.DataEntity

interface ContentCallback {
    fun onItemClicked(data: DataEntity)
}