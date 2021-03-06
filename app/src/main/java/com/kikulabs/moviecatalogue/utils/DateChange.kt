package com.kikulabs.moviecatalogue.utils

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

class DateChange {
    fun changeFormatDate(changeFormat: String?): String? {
        try {
            @SuppressLint("SimpleDateFormat") val formatter: DateFormat =
                SimpleDateFormat("yyyy-MM-dd")
            @SuppressLint("SimpleDateFormat") val dateFormat =
                SimpleDateFormat("dd MMMM yyyy")
            val date = formatter.parse(changeFormat)
            return dateFormat.format(date)
        } catch (ignored: ParseException) {
        }
        return changeFormat
    }
}