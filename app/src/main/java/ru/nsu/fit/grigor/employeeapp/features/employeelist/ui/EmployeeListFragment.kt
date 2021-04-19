package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.nsu.fit.grigor.employeeapp.R
import ru.nsu.fit.grigor.employeeapp.databinding.FragmentEmployeeListBinding
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.bind.bindData
import ru.nsu.fit.grigor.employeeapp.library.navigation.EmployeeDetailModuleKey
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeListFragment : Fragment(), EmployeeListViewModel.EventsListener {

    private lateinit var binding: FragmentEmployeeListBinding

    private val viewModel: EmployeeListViewModel by viewModel {
        parametersOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        otherSetups()
        return binding.root
    }

    private fun otherSetups() {
        viewModel.setEventListener(this)
        bindData(viewModel, binding)
    }

    override fun navigateToEmployeeDetail(employee: EmployeeEntity) {
        findNavController().navigate(
            R.id.action_employeeListFragment_to_employeeDetailFragment,
            bundleOf().apply {
                putSerializable(EmployeeDetailModuleKey.EMPLOYEE, employee)
            }
        )
    }
}