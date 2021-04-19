package ru.nsu.fit.grigor.employeeapp.shared.employee.domain.di

import org.koin.dsl.module
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.usecase.GetEmployeesUseCase

internal val UseCaseModule = module {
    single<GetEmployeesUseCase> { GetEmployeesUseCase(get()) }
}

val EmployeeDomainModule = listOf(
    UseCaseModule,
)