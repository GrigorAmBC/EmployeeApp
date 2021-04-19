package ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dao.EmployeesDao
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.EmployeeDto
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.mapper.toDtoList
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.mapper.toEntityList
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeLocalDataSourceImpl(
    private val dao: EmployeesDao
) : EmployeeLocalDataSource {

    override suspend fun getEmployees(): List<EmployeeEntity> =
        withContext(Dispatchers.IO) {
            dao.getEscorts().toEntityList()
        }

    override suspend fun insertEmployees(employees: List<EmployeeEntity>) {
        dao.insertEscorts(employees.toDtoList())
    }
}