package ru.nsu.fit.grigor.employeeapp.shared.employee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.converter.Converters
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dao.EmployeesDao
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.EmployeeDto

@Database(entities = [EmployeeDto::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class EmployeeDatabase : RoomDatabase() {

    companion object {

        const val NAME = "EMPLOYEE_DATA_BASE_NAME"
    }

    abstract fun employeeDao(): EmployeesDao
}