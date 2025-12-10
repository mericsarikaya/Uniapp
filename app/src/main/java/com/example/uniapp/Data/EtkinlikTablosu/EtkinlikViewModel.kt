package com.example.uniapp.data.etkinlik

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EtkinlikViewModel(application: Application) : AndroidViewModel(application) {

    private val etkinlikDao: EtkinlikDao
    val tumEtkinlikler: LiveData<List<EtkinlikTablosu>>

    init {
        val dao = UniAppDatabase.getDatabase(application).etkinlikDao()
        etkinlikDao = dao
        tumEtkinlikler = dao.tumEtkinlikleriGetir()
    }

    fun etkinlikEkle(etkinlik: EtkinlikTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            etkinlikDao.etkinlikEkle(etkinlik)
        }
    }
}
