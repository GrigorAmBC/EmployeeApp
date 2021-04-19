package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.grigor.employeeapp.databinding.ItemEmployeeBinding
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.library.util.getAge
import ru.nsu.fit.grigor.employeeapp.library.util.getFormattedFirstName
import ru.nsu.fit.grigor.employeeapp.library.util.getFormattedLastName
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeViewHolder(private val binding: ItemEmployeeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun from(parent: ViewGroup): EmployeeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemEmployeeBinding.inflate(layoutInflater, parent, false)
            return EmployeeViewHolder(binding)
        }
    }

    fun bind(employee: EmployeeEntity, viewModel:EmployeeListViewModel) {
        with(binding) {
            employeeFirstName.text = employee.getFormattedFirstName()
            employeeLastName.text = employee.getFormattedLastName()
            employeeAge.text = employee.getAge()
            root.setOnClickListener {
                viewModel.onEmployeeItemClick(employee)
            }
        }
    }
}