package com.example.kmp_base.core.network

import kotlinx.coroutines.flow.Flow

interface INetworkMonitor {

    val isOnline: Flow<Boolean>

    fun isCurrentlyOnline(): Boolean
}