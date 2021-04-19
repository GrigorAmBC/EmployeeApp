package ru.nsu.fit.grigor.employeeapp.shared.employee.data.mapper

import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.EmployeeDto
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

fun EmployeeDto.toEntity(): EmployeeEntity =
    EmployeeEntity(
        firstName = firstName,
        lastName = lastName,
        birthDate = birthDate,
        avatarUrl = avatarUrl,
        specialty = specialty.toEntityList()
    )

fun EmployeeEntity.toDto(): EmployeeDto =
    EmployeeDto(
        firstName = firstName,
        lastName = lastName,
        birthDate = birthDate,
        avatarUrl = avatarUrl,
        specialty = specialty.toDtoList()
    )

fun List<EmployeeDto>.toEntityList(): List<EmployeeEntity> = map {
    it.toEntity()
}

fun List<EmployeeEntity>.toDtoList(): List<EmployeeDto> = map {
    it.toDto()
}