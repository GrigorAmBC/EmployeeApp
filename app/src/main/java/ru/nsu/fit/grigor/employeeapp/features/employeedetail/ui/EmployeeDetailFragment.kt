package ru.nsu.fit.grigor.employeeapp.features.employeedetail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.nsu.fit.grigor.employeeapp.R
import ru.nsu.fit.grigor.employeeapp.databinding.FragmentEmployeeDetailBinding
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.presenter.EmployeeDetailViewModel
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.ui.bind.bindData
import ru.nsu.fit.grigor.employeeapp.library.navigation.EmployeeDetailModuleKey
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeDetailFragment : Fragment() {

    private lateinit var _binding: FragmentEmployeeDetailBinding
    val binding
        get() = _binding

    private val viewModel: EmployeeDetailViewModel by viewModel {
        parametersOf(
            arguments?.get(EmployeeDetailModuleKey.EMPLOYEE)
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        otherSetups()
        return _binding.root
    }

    private fun otherSetups() {
        bindData(viewModel, _binding)
    }
}