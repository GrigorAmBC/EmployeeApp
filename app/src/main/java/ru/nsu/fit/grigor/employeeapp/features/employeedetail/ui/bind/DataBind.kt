package ru.nsu.fit.grigor.employeeapp.features.employeedetail.ui.bind

import com.bumptech.glide.Glide
import ru.nsu.fit.grigor.employeeapp.R
import ru.nsu.fit.grigor.employeeapp.databinding.FragmentEmployeeDetailBinding
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.presenter.EmployeeDetailViewModel
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.ui.EmployeeDetailFragment
import ru.nsu.fit.grigor.employeeapp.library.util.getAge
import ru.nsu.fit.grigor.employeeapp.library.util.getFormattedBirthDate
import ru.nsu.fit.grigor.employeeapp.library.util.getFormattedFirstName
import ru.nsu.fit.grigor.employeeapp.library.util.getFormattedLastName

fun EmployeeDetailFragment.bindData(
    viewModel: EmployeeDetailViewModel,
    binding: FragmentEmployeeDetailBinding
) {
    with(binding) {
        viewModel.employee.let {
            employeeFirstName.text = it.getFormattedFirstName()
            employeeLastName.text = it.getFormattedLastName()
            employeeAge.text = it.getAge()
            employeeDateOfBirth.text = it.getFormattedBirthDate()
            Glide.with(this@bindData)
                .load(viewModel.employee.avatarUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(employeeAvatar)
        }
    }
}