package ru.nsu.fit.grigor.employeeapp.shared.employee.domain.usecase

import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.repository.EmployeeRepository

class GetEmployeesUseCase(private val repository: EmployeeRepository) {

    suspend operator fun invoke(): List<EmployeeEntity> =
        repository.getEmployees()
}