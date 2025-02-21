package com.ds.basicapp.ui.heroes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ds.basicapp.domain.models.Characters
import com.ds.basicapp.domain.repositories.LocalDataRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach

class HeroViewModel(private val localDataRepository: LocalDataRepository) : ViewModel() {
    private val _charactersLiveData: MutableLiveData<Characters> = MutableLiveData(emptyArray())
    val charactersLiveData: LiveData<Characters> = _charactersLiveData

    fun loadData() {
        localDataRepository.heroes()
            .onEach { heroes ->
                Log.d("Heroes loaded", "$heroes")
                _charactersLiveData.postValue(heroes)
            }
            .catch { exception ->
                Log.d("Heroes load error", "$exception")
            }
            .launchIn(viewModelScope)
    }
}