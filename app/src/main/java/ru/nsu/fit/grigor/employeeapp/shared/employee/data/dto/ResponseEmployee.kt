package ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseEmployee(
    @Json(name = "response") val response: List<EmployeeDto>
)