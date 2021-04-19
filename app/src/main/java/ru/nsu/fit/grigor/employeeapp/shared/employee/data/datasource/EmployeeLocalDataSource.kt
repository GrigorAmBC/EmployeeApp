package ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource

import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

interface EmployeeLocalDataSource {

    suspend fun getEmployees(): List<EmployeeEntity>

    suspend fun insertEmployees(employees: List<EmployeeEntity>)
}