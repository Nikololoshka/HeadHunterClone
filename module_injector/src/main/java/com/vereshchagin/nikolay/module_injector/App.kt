package com.vereshchagin.nikolay.module_injector

interface App {

    fun appDependenciesProvider(): AppDependenciesProvider
}