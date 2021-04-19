package ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource

import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

interface EmployeeRemoteDataSource {

    suspend fun getEmployees(): List<EmployeeEntity>
}