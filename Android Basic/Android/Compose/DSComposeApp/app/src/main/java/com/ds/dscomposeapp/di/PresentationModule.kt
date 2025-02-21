package com.ds.dscomposeapp.di

import com.ds.dscomposeapp.presentation.list.ListViewModel
import com.ds.dscomposeapp.presentation.detail.DetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { DetailViewModel(get()) }
    viewModel { ListViewModel(get()) }
}