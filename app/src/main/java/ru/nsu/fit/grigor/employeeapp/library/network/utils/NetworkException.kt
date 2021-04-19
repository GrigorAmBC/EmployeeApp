package ru.nsu.fit.grigor.employeeapp.library.network.utils

object NetworkCode {

    const val SERVER_CONNECTION_ERROR = 544656
    const val UNKNOWN = 78885
}

data class NetworkException(
    val message: String? = null,
    val code: Int? = null
)