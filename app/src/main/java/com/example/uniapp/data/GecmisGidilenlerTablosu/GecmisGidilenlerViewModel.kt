package com.example.uniapp.data.gecmisgidilenler

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GecmisGidilenlerViewModel(application: Application) : AndroidViewModel(application) {

    private val gecmisGidilenlerDao: GecmisGidilenlerDao

    init {
        val dao = UniAppDatabase.getDatabase(application).gecmisGidilenlerDao()
        gecmisGidilenlerDao = dao
    }

    fun gidilenEkle(gecmisGidilenler: GecmisGidilenlerTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            gecmisGidilenlerDao.gidilenEkle(gecmisGidilenler)
        }
    }

    fun kisiGecmisiniGetir(kisiId: Int): LiveData<List<GecmisGidilenlerTablosu>> {
        return gecmisGidilenlerDao.kisiGecmisiniGetir(kisiId)
    }
}
