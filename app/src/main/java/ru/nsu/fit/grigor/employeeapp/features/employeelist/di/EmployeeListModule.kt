package ru.nsu.fit.grigor.employeeapp.features.employeelist.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel

private val ViewModelModule = module {
    viewModel {
//            (toolbarBackStackTitle: String?, id: Int) ->
        EmployeeListViewModel(
            getEmployeesUseCase = get()
//            getEventDetailUseCase = get(),
//            toolbarBackStackTitle = toolbarBackStackTitle,
//            tokenExistsUseCase = get(),
//            id = id,
//            subscribeTagUseCase = get(),
//            subscribeEventTypesUseCase = get(),
//            updateAllCacheByHashScenario = get(),
//            applicationScope = get()
        )
    }
}

val EmployeeListModule = listOf(
    ViewModelModule
)