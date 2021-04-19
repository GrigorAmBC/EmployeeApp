package ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto

import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
@Entity(tableName = "Employees")
data class EmployeeDto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "f_name") @Json(name = "f_name") val firstName: String,
    @ColumnInfo(name = "l_name") @Json(name = "l_name") val lastName: String,
    @ColumnInfo(name = "birthday") @Json(name = "birthday") val birthDate: Date?,
    @ColumnInfo(name = "avatr_url") @Json(name = "avatr_url") val avatarUrl: String?,
    @ColumnInfo(name = "specialty") @Json(name = "specialty") val specialty: List<SpecialtyDto>
)