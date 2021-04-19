package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.bind

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.nsu.fit.grigor.employeeapp.databinding.FragmentEmployeeListBinding
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.EmployeeListFragment
import ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.recyclerview.SpecialtyRVAdapter

fun EmployeeListFragment.bindData(
    viewModel: EmployeeListViewModel,
    binding: FragmentEmployeeListBinding
) {
    with(binding) {
        val adapter = SpecialtyRVAdapter(viewModel)
        recyclerView.adapter = adapter
        viewModel.specialtiesFlow.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)

        recyclerView.bindUIState(viewLifecycleOwner, viewModel.uiState)
        retryButton.setOnClickListener { viewModel.retry() }
        retryButton.bindUIState(viewLifecycleOwner, viewModel.uiState)
        progressBar.bindUIState(viewLifecycleOwner, viewModel.uiState)
        bindError(viewModel.uiState)
    }
}