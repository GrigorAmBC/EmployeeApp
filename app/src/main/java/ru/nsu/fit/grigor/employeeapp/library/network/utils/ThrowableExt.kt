package ru.nsu.fit.grigor.employeeapp.library.network.utils

import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkException(): NetworkException {
    val code = when (this) {
        is IOException   -> NetworkCode.SERVER_CONNECTION_ERROR
        is HttpException -> this.code()
        else             -> NetworkCode.UNKNOWN
    }
    return NetworkException(message = message, code = code)
}

