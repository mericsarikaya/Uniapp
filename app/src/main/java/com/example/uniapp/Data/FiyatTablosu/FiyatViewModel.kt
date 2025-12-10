package com.example.uniapp.data.fiyat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FiyatViewModel(application: Application) : AndroidViewModel(application) {

    private val fiyatDao: FiyatDao
    val tumFiyatlar: LiveData<List<FiyatTablosu>>

    init {
        val dao = UniAppDatabase.getDatabase(application).fiyatDao()
        fiyatDao = dao
        tumFiyatlar = dao.tumFiyatlariGetir()
    }

    fun fiyatEkle(fiyat: FiyatTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            fiyatDao.fiyatEkle(fiyat)
        }
    }
}
