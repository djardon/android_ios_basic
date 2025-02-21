package com.ds.kmmproject.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ds.kmmproject.domain.models.Museum
import com.ds.kmmproject.domain.usecases.GetMuseumsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListViewModel(
    private val getMuseumsUseCase: GetMuseumsUseCase
) : ViewModel() {
    private val _museums = MutableStateFlow<List<Museum>>(emptyList())
    val museums: StateFlow<List<Museum>> = _museums
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {
        fetchMuseum()
    }

    private fun fetchMuseum() {
        viewModelScope.launch {
            _museums.value = getMuseumsUseCase.execute()
        }
    }
}