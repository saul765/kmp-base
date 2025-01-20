package com.example.kmp_base.core.model

import androidx.annotation.StringRes
import com.example.kmp_base.core.ZERO_INTEGER

data class LoadingState(
    val isLoading: Boolean = false,
    @StringRes val message: Int? = ZERO_INTEGER
)