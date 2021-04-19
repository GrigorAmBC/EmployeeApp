package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.bind

import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.nsu.fit.grigor.employeeapp.R
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.uistate.UiState
import ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.EmployeeListFragment
import ru.nsu.fit.grigor.employeeapp.library.network.utils.NetworkCode

fun ProgressBar.bindUIState(
    owner: LifecycleOwner,
    state: Flow<UiState>
) = state.onEach {
    isVisible = it is UiState.Loading
}.launchIn(owner.lifecycle.coroutineScope)

fun Button.bindUIState(
    owner: LifecycleOwner,
    state: Flow<UiState>
) = state.onEach {
    isVisible = it is UiState.Error
}.launchIn(owner.lifecycle.coroutineScope)

fun RecyclerView.bindUIState(
    owner: LifecycleOwner,
    state: Flow<UiState>
) = state.onEach {
    isVisible = it is UiState.Content
}.launchIn(owner.lifecycle.coroutineScope)

fun EmployeeListFragment.bindError(
    state: Flow<UiState>
) = state.onEach {
    if (it is UiState.Error) {
        val messageId = if (it.errorCode == NetworkCode.SERVER_CONNECTION_ERROR) {
            R.string.error_no_internet
        } else {
            R.string.error_unknown
        }
        Toast.makeText(requireContext(), messageId, Toast.LENGTH_LONG).show()
    }
}.launchIn(lifecycleScope)