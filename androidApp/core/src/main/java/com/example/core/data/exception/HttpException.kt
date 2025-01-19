package com.example.core.data.exception

import com.example.core.model.DataError

class HttpException(
    val errorType: DataError.Network,
    override val message: String?
) : Exception(message)