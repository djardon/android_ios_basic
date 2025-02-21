package com.ds.basicapp.ui.villains

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ds.basicapp.domain.models.Characters
import com.ds.basicapp.domain.repositories.LocalDataRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class VillainsViewModel(private val localDataRepository: LocalDataRepository) : ViewModel() {
    private val _villainsLiveData: MutableLiveData<Characters> = MutableLiveData(emptyArray())
    val villainsLiveData: LiveData<Characters> = _villainsLiveData

    fun loadData() {
        localDataRepository.villains()
            .onEach { heroes ->
                Log.d("Heroes loaded", "$heroes")
                _villainsLiveData.postValue(heroes)
            }
            .catch { exception ->
                Log.d("Heroes load error", "$exception")
            }
            .launchIn(viewModelScope)
    }
}