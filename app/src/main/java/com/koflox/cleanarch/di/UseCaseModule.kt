package com.koflox.cleanarch.di

import com.koflox.cleanarch.use_cases.MainUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        MainUseCase()
    }
}