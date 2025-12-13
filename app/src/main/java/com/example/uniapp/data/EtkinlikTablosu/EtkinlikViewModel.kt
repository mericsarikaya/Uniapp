package com.example.uniapp.data.EtkinlikTablosu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import com.example.uniapp.data.etkinlik.etkinlik
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EtkinlikViewModel(application: Application) : AndroidViewModel(application) {

    val tumEtkinlikler: LiveData<List<etkinlik>>
    private val repository: EtkinlikRepository

    init {
        val etkinlikDao = UniAppDatabase.getDatabase(application).etkinlikDao()
        repository = EtkinlikRepository(etkinlikDao)
        tumEtkinlikler = repository.tumEtkinlikler
    }

    fun etkinlikEkle(etkinlik: etkinlik) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.etkinlikEkle(etkinlik)
        }
    }
}
