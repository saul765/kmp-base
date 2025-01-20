package com.example.kmp_base.core.data.exception

import com.example.kmp_base.core.model.DataError

class HttpException(
    val errorType: DataError.Network,
    override val message: String?
) : Exception(message)