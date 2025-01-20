package com.example.kmp_base

import com.example.kmp_base.core.base.IBaseAppConfig

object AppConfig : IBaseAppConfig {
    override fun getRemoteConfigDefaultValues(): Map<String, Any> = emptyMap()
}