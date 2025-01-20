package com.example.kmp_base.di

object CommonModule {

    private val useCasesModule = listOf(
        UseCasesModule.module
    )

    private val webServiceModule = listOf(
        WebServiceModule.module
    )

    private val repositoriesModule = listOf(
        RepositoriesModule.module
    )

    private val utilsModule = listOf(
        UtilsModule.module
    )


    val sharedModules = useCasesModule + utilsModule + webServiceModule + repositoriesModule
}