package ru.nsu.fit.grigor.employeeapp.features.employeelist.ui.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.nsu.fit.grigor.employeeapp.features.employeelist.presentation.EmployeeListViewModel
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.entity.SpecialtyEntity

class SpecialtyRVAdapter(
    private val viewModel: EmployeeListViewModel
) : ListAdapter<SpecialtyEntity, SpecialtyViewHolder>(
    SpecialtiesDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder =
        SpecialtyViewHolder.from(parent, viewModel)

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        val specialtyEntity = getItem(position)
        holder.bind(specialtyEntity, viewModel.getEmployeesBySpecialty(specialtyEntity))
    }
}

class SpecialtiesDiffCallback : DiffUtil.ItemCallback<SpecialtyEntity>() {

    override fun areItemsTheSame(oldItem: SpecialtyEntity, newItem: SpecialtyEntity) =
        oldItem.specialtyId == newItem.specialtyId

    override fun areContentsTheSame(oldItem: SpecialtyEntity, newItem: SpecialtyEntity) =
        oldItem == newItem
}