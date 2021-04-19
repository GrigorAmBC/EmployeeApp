package ru.nsu.fit.grigor.employeeapp.features.employeedetail.presenter

import androidx.lifecycle.ViewModel
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeDetailViewModel(
    val employee: EmployeeEntity
) : ViewModel() {

}