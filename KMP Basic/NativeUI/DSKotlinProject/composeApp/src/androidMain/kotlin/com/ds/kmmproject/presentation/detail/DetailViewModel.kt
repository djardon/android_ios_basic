package com.ds.kmmproject.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ds.kmmproject.domain.models.Museum
import com.ds.kmmproject.domain.usecases.GetMuseumUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    private val getMuseumUseCase: GetMuseumUseCase
) : ViewModel() {
    private val museumId = MutableStateFlow<Long?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val museumObject: StateFlow<Museum?> = museumId
        .flatMapLatest { id ->
            flow {
                emit(id?.let { getMuseumUseCase.execute(it) })
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            null
        )

    fun setId(museumId: Long) {
        this.museumId.value = museumId
    }
}