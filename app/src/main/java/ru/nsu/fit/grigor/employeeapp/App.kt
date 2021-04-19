package ru.nsu.fit.grigor.employeeapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.nsu.fit.grigor.employeeapp.features.employeedetail.di.EmployeeDetailModule
import ru.nsu.fit.grigor.employeeapp.features.employeelist.di.EmployeeListModule
import ru.nsu.fit.grigor.employeeapp.library.network.retrofit.NetworkModule
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.di.EmployeeDataModule
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.di.EmployeeDomainModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(NetworkModule)
            modules(EmployeeListModule)
            modules(EmployeeDomainModule + EmployeeDataModule)
            modules(EmployeeDetailModule)
        }
    }
}