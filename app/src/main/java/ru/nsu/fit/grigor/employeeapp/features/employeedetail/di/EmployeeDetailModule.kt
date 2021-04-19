package ru.nsu.fit.grigor.employeeapp.features.employeedetail.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.presenter.EmployeeDetailViewModel
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

private val ViewModelModule = module {
    viewModel { (employee: EmployeeEntity) ->
        EmployeeDetailViewModel(
            employee = employee
        )
    }
}

val EmployeeDetailModule = listOf(
    ViewModelModule
)