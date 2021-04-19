package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.EmployeeEntity

class EmployeeRVAdapter(
    private val viewModel: EmployeeListViewModel,
    private val employees: List<EmployeeEntity>
) : RecyclerView.Adapter<EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
        EmployeeViewHolder.from(parent)

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employees[position], viewModel)
    }

    override fun getItemCount(): Int =
        employees.size
}