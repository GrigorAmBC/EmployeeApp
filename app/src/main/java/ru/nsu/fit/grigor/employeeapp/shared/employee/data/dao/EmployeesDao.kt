package ru.nsu.fit.grigor.employeeapp.shared.employee.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.EmployeeDto

@Dao
interface EmployeesDao {

    @Query("SELECT * FROM Employees")
    suspend fun getEscorts(): List<EmployeeDto>

    @Query("SELECT * FROM Employees")
    fun getFlowEscorts(): Flow<List<EmployeeDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEscorts(employees: List<EmployeeDto>)
}