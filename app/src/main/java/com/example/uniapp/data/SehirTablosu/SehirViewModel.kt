package com.example.uniapp.data.sehir

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SehirViewModel(application: Application) : AndroidViewModel(application) {

    private val sehirDao: SehirDao
    val tumSehirler: LiveData<List<SehirTablosu>>

    init {
        val dao = UniAppDatabase.getDatabase(application).sehirDao()
        sehirDao = dao
        tumSehirler = dao.tumSehirleriGetir()
    }

    fun sehirEkle(sehir: SehirTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            sehirDao.sehirEkle(sehir)
        }
    }
}
