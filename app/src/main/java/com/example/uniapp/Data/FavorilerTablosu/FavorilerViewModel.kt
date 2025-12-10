package com.example.uniapp.data.favoriler

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavorilerViewModel(application: Application) : AndroidViewModel(application) {

    private val favorilerDao: FavorilerDao

    init {
        favorilerDao = UniAppDatabase.getDatabase(application).favorilerDao()
    }

    fun favoriEkle(favori: FavorilerTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            favorilerDao.favoriEkle(favori)
        }
    }

    fun kisiFavorileriniGetir(kisiId: Int): LiveData<List<FavorilerTablosu>> {
        return favorilerDao.kisiFavorileriniGetir(kisiId)
    }
}
