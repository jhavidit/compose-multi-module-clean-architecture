package com.jhavidit.core

sealed class ApiResult<out T> {
    data object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val code: Int? = null, val errorBody: String? = null) : ApiResult<Nothing>()
    data object Unauthorized : ApiResult<Nothing>()  // For 401 Unauthorized
    data object NetworkError : ApiResult<Nothing>()  // For connectivity issues
    data object ServerError : ApiResult<Nothing>()   // For 5xx server errors
}