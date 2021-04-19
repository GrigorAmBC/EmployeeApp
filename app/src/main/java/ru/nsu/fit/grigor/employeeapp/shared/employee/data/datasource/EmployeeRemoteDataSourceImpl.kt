package ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource

import kotlinx.coroutines.Dispatchers
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import kotlinx.coroutines.withContext
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.api.EmployeeApi
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.mapper.toEntityList

class EmployeeRemoteDataSourceImpl(
    private val api: EmployeeApi
) : EmployeeRemoteDataSource {

    override suspend fun getEmployees(): List<EmployeeEntity> =
        withContext(Dispatchers.IO) {
            api.getEmployees().response.toEntityList()
        }
}