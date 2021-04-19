package ru.nsu.fit.grigor.employeeapp.shared.employee.data.api

import retrofit2.http.GET
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.EmployeeDto
import ru.nsu.fit.grigor.employeeapp.shared.employee.data.dto.ResponseEmployee

interface EmployeeApi {

    @GET("/65gb/static/raw/master/testTask.json")
    suspend fun getEmployees(): ResponseEmployee
}