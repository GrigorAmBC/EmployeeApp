package ru.nsu.fit.grigor.employeeapp.shared.employee.data.mapper

import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.SpecialtyDto
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.SpecialtyEntity


fun SpecialtyEntity.toDto() =
    SpecialtyDto(
        specialtyId = specialtyId,
        name = name
    )

fun SpecialtyDto.toEntity() =
    SpecialtyEntity(
        specialtyId = specialtyId,
        name = name
    )

fun List<SpecialtyEntity>.toDtoList(): List<SpecialtyDto> = map {
    it.toDto()
}

fun List<SpecialtyDto>.toEntityList(): List<SpecialtyEntity> = map {
    it.toEntity()
}