package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.grigor.employeeapp.databinding.ItemSpecialtyBinding
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.SpecialtyEntity

class SpecialtyViewHolder(
    private val binding: ItemSpecialtyBinding,
    private val viewModel: EmployeeListViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun from(parent: ViewGroup, viewModel: EmployeeListViewModel): SpecialtyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSpecialtyBinding.inflate(layoutInflater, parent, false)
            return SpecialtyViewHolder(binding, viewModel)
        }
    }

    fun bind(specialty: SpecialtyEntity, employees: List<EmployeeEntity>) {
        with(binding) {
            specialtyTextView.text = specialty.name
            val adapter = EmployeeRVAdapter(viewModel, employees)
            employeeRecyclerView.adapter = adapter
            employeeRecyclerView.isVisible = false
            binding.root.setOnClickListener {
                employeeRecyclerView.apply {
                    isVisible = !isVisible
                }
            }
        }
    }
}