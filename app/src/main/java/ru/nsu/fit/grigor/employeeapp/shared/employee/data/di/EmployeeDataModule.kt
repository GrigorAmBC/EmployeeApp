package ru.nsu.fit.grigor.employeeapp.shared.employee.data.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.nsu.fit.grigor.employeeapp.library.network.retrofit.createRetrofitService
import ru.nsu.fit.grigor.employeeapp.library.network.retrofit.getRetrofit
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.api.EmployeeApi
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dao.EmployeesDao
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.database.EmployeeDatabase
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeLocalDataSource
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeLocalDataSourceImpl
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeRemoteDataSource
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.datasource.EmployeeRemoteDataSourceImpl
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.repository.EmployeeRepositoryImpl
import ru.nsu.fit.grigor.employeeapp.shared.employee.domain.repository.EmployeeRepository

internal val DatabaseModule = module {
    single<EmployeeDatabase> {
        Room.databaseBuilder(androidContext(), EmployeeDatabase::class.java, EmployeeDatabase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}

internal val DaoModule = module {
    single<EmployeesDao> { get<EmployeeDatabase>().employeeDao() }
}

internal val RetrofitModule = module {
    factory { createRetrofitService<EmployeeApi>(getRetrofit()) }
}

internal val DataSourceModule = module {
    single<EmployeeLocalDataSource> { EmployeeLocalDataSourceImpl(get()) }
    single<EmployeeRemoteDataSource> { EmployeeRemoteDataSourceImpl(get()) }
}

internal val RepositoryModule = module {
    single<EmployeeRepository> { EmployeeRepositoryImpl(get(), get()) }
}

val EmployeeDataModule = listOf(
    DatabaseModule,
    DaoModule,
    RetrofitModule,
    DataSourceModule,
    RepositoryModule
)