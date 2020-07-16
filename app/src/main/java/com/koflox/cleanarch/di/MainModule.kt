package com.koflox.cleanarch.di

import com.koflox.cleanarch.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            app = get(),
            mainUseCase = get()
        )
    }
}

val appModules = listOf(viewModelModule, networkModule, useCaseModule)