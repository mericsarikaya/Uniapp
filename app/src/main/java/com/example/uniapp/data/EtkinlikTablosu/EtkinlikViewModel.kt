package com.example.uniapp.data.etkinlik

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import com.example.uniapp.data.etkinlik.etkinlik
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EtkinlikViewModel(application: Application): AndroidViewModel(application) {
    private val verilerioku: LiveData<List<etkinlik>>
    private val repository: EtkinlikRepository

    init {
        val EtkinlikDao = UniAppDatabase.Companion.getDatabase(application).etkinlikDao()
        repository = EtkinlikRepository(EtkinlikDao)
        verilerioku = repository.verioku
    }
    fun etkinlikEkle(etkinlik: etkinlik){
        viewModelScope.launch (Dispatchers.IO){
            repository.etkinlikekleme(etkinlik)
        }
    }
    fun verioku(etkinlik: etkinlik){
        viewModelScope.launch (Dispatchers.IO){
            repository.veriokuma(etkinlik)
        }
    }
}