package ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity

import java.io.Serializable
import java.util.Date

data class EmployeeEntity(
    val firstName: String,
    val lastName: String,
    val birthDate: Date?,
    val avatarUrl: String?,
    val specialty: List<SpecialtyEntity>
): Serializable