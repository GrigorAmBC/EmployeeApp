package ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecialtyDto(
    @Json(name = "specialty_id") val specialtyId: Int,
    @Json(name = "name") val name: String
)