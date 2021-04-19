package ru.nsu.fit.grigor.employeeapp.library.util

import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import java.text.SimpleDateFormat
import java.util.*

fun EmployeeEntity.getAge(): String =
    if (birthDate == null || birthDate.toString().isBlank()) {
        "-"
    } else {
        val dob = Calendar.getInstance().apply { time = birthDate }
        val today = Calendar.getInstance()

        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]

        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }

        "$age y.o."
    }


fun EmployeeEntity.getFormattedBirthDate(): String =
    if (birthDate == null || birthDate.toString().isBlank()) {
        "-"
    } else {
        val newDateFormat = SimpleDateFormat("dd.MM.yyyy г.")
        val result = newDateFormat.format(birthDate)
        result
    }


fun EmployeeEntity.getFormattedFirstName(): String =
    with(firstName) {
        substring(0, 1).toUpperCase(Locale.ROOT) + substring(1).toLowerCase(Locale.ROOT)
    }

fun EmployeeEntity.getFormattedLastName(): String =
    with(lastName) {
        substring(0, 1).toUpperCase(Locale.ROOT) + substring(1).toLowerCase(Locale.ROOT)
    }






