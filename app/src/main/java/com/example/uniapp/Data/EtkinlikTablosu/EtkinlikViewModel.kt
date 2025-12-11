package com.example.uniapp.Data.Profil

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import com.example.uniapp.data.etkinlik.EtkinlikTablo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EtkinlikViewModel(application: Application): AndroidViewModel(application) {
    private val verilerioku: LiveData<List<EtkinlikTablo>>
    private val repository: EtkinlikRepository

    init {
        val EtkinlikDao = UniAppDatabase.Companion.getDatabase(application).etkinlikDao()
        repository = EtkinlikRepository(EtkinlikDao)
        verilerioku = repository.verioku
    }
    fun etkinlikEkle(etkinlikTablo: EtkinlikTablo){
        viewModelScope.launch (Dispatchers.IO){
            repository.etkinlikekleme(etkinlikTablo)
        }
    }
    fun verioku(etkinlikTablo: EtkinlikTablo){
        viewModelScope.launch (Dispatchers.IO){
            repository.veriokuma(etkinlikTablo)
        }
    }
}