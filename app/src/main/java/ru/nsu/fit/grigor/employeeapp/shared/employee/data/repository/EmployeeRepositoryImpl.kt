package ru.nsu.fit.grigor.employeeapp.shared.employee.data.repository

import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeLocalDataSource
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeRemoteDataSource
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.repository.EmployeeRepository

class EmployeeRepositoryImpl(
    private val localDataSource: EmployeeLocalDataSource,
    private val remoteDataSource: EmployeeRemoteDataSource
) : EmployeeRepository {

    override suspend fun getEmployees(): List<EmployeeEntity> {
        var result = localDataSource.getEmployees()
        if (result.isEmpty()) {
            result = remoteDataSource.getEmployees()
            localDataSource.insertEmployees(result)
        }

        return result
    }
}