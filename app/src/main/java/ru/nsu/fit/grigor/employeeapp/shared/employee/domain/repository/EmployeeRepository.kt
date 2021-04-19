package ru.nsu.fit.grigor.employeeapp.shared.employee.domain.repository

import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

interface EmployeeRepository {

    suspend fun getEmployees(): List<EmployeeEntity>
}