package com.ds.basicapp.di

import com.ds.basicapp.ui.character.CharacterViewModel
import com.ds.basicapp.ui.heroes.HeroViewModel
import com.ds.basicapp.ui.villains.VillainsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HeroViewModel(get()) }
    viewModel { VillainsViewModel(get()) }
    viewModel { CharacterViewModel() }
}