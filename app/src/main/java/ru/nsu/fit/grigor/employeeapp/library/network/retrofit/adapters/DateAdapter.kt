package ru.nsu.fit.grigor.employeeapp.library.network.retrofit.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateAdapter {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    private val dateFormats: List<SimpleDateFormat> = listOf(
        SimpleDateFormat("yyyy-MM-dd"),
        SimpleDateFormat("dd-MM-yyyy")
    )

    init {
        dateFormats.forEach {
            it.isLenient = false
        }
    }

    @ToJson
    @Synchronized
    fun dateToJson(date: Date?): String? {
        return date?.let(dateFormat::format)
    }

    @FromJson
    @Synchronized
    fun dateToJson(string: String?): Date? {
        return if (string.isNullOrBlank()) {
            null
        } else {
            for (dateFormat in dateFormats) {
                try {
                    return dateFormat.parse(string)
                } catch (e: ParseException) {
                }
            }
            return null
        }
    }
}
