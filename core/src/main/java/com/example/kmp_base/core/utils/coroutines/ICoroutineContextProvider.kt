package com.example.kmp_base.core.utils.coroutines

import kotlin.coroutines.CoroutineContext

interface ICoroutineContextProvider {

    fun getMainContext(): CoroutineContext

    fun getIOContext(): CoroutineContext

    fun getDefaultContext(): CoroutineContext

}