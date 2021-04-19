package ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.uistate

sealed class UiState {
    object Loading : UiState()
    object Content : UiState()
    data class Error(val errorCode: Int?) : UiState()
}
