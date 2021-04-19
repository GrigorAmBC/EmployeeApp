package ru.nsu.fit.grigor.employeeapp.shared.employee.data.converter

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.SpecialtyDto
import java.util.*

class Converters {
    private val moshi = Moshi.Builder().build()

    private val specialtyDtoListAdapter: JsonAdapter<List<SpecialtyDto>>

    init {
        val type = Types.newParameterizedType(List::class.java, SpecialtyDto::class.java)
        specialtyDtoListAdapter = moshi.adapter(type)
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? =
        value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? =
        date?.time

    @TypeConverter
    fun specialtyDtoListToString(specialtyList: List<SpecialtyDto>?): String? =
        specialtyDtoListAdapter.toJson(specialtyList)

    @TypeConverter
    fun specialtyDtoListFromString(string: String?): List<SpecialtyDto>? =
        string?.let { specialtyDtoListAdapter.fromJson(string) }
}