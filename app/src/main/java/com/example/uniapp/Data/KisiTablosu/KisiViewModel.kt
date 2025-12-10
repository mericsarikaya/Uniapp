package com.example.uniapp.data.kisi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiViewModel(application: Application) : AndroidViewModel(application) {

    val verileriOku: LiveData<List<KisiTablosu>>
    private val kisiDao: KisiDao

    init {
        kisiDao = UniAppDatabase.getDatabase(application).kisiDao()
        verileriOku = kisiDao.veriOku()
    }

    fun kisiEkle(kisi: KisiTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            kisiDao.kisiEkle(kisi)
        }
    }

    suspend fun sifreKontrol(kullaniciIsim: String): KisiTablosu? {
        return kisiDao.sifreKontrol(kullaniciIsim)
    }
}
