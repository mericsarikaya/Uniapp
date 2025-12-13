package com.example.uniapp.data.kisiTablosu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import com.example.uniapp.data.kisi.KisiTablosu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiViewModel(application: Application) : AndroidViewModel(application) {

    private val kisiDao: KisiDao
    val verileriOku: LiveData<List<KisiTablosu>>

    init {
        // Repository katmanı olmadan, DAO'ya doğrudan erişim sağlıyoruz.
        kisiDao = UniAppDatabase.getDatabase(application).kisiDao()
        verileriOku = kisiDao.veriOku()
    }

    fun kisiEkle(kisi: KisiTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            kisiDao.kisiEkle(kisi)
        }
    }

    fun kisiGuncelle(kisi: KisiTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            kisiDao.kisiGuncelle(kisi)
        }
    }

    suspend fun sifreKontrol(kullaniciIsim: String): KisiTablosu? {
        return kisiDao.sifreKontrol(kullaniciIsim)
    }
}
