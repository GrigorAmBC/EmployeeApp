package ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.uistate.UiState
import ru.nsu.fit.grigor.employeeapp.library.network.utils.toNetworkException
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.SpecialtyEntity
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.usecase.GetEmployeesUseCase

class EmployeeListViewModel(
    private val getEmployeesUseCase: GetEmployeesUseCase
) : ViewModel() {

    interface EventsListener {

        fun navigateToEmployeeDetail(employee: EmployeeEntity)
    }

    private var eventListener: EventsListener? = null

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState>
        get() = _uiState
    private val _employeeListFlow = MutableStateFlow<List<EmployeeEntity>>(emptyList())
    val employeeListFlow: StateFlow<List<EmployeeEntity>>
        get() = _employeeListFlow

    val specialtiesFlow: Flow<List<SpecialtyEntity>> = employeeListFlow.map { employees ->
        val list = mutableListOf<SpecialtyEntity>()
        employees.map {
            list.addAll(it.specialty)
        }
        list.distinct()
    }

    init {
        fetchEmployees()
    }

    private fun fetchEmployees() {
        viewModelScope.launch {
            try {
                _uiState.value = UiState.Loading
                _employeeListFlow.value = getEmployeesUseCase()
                _uiState.value = UiState.Content
            } catch (throwable: Throwable) {
                val code = throwable.toNetworkException().code
                _uiState.value = UiState.Error(code)
            }
        }
    }

    fun setEventListener(eventListener: EventsListener) {
        this.eventListener = eventListener
    }

    fun onEmployeeItemClick(employee: EmployeeEntity) {
        eventListener?.navigateToEmployeeDetail(employee)
    }

    fun getEmployeesBySpecialty(specialty: SpecialtyEntity): List<EmployeeEntity> =
        _employeeListFlow.value.filter {
            it.specialty.contains(specialty)
        }


    fun retry() {
        if (_uiState.value is UiState.Error) {
            fetchEmployees()
        }
    }
}