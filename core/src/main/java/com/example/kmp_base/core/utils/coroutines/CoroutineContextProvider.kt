package com.example.kmp_base.core.utils.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineContextProvider : ICoroutineContextProvider {
    override fun getMainContext(): CoroutineContext = Dispatchers.Main

    override fun getIOContext(): CoroutineContext = Dispatchers.IO

    override fun getDefaultContext(): CoroutineContext = Dispatchers.Default
}
