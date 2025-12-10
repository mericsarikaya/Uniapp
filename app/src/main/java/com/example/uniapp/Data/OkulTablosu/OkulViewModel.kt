package com.example.uniapp.data.okul

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OkulViewModel(application: Application) : AndroidViewModel(application) {

    val verileriOku: LiveData<List<OkulTablosu>>
    private val okulDao: OkulDao

    init {
        okulDao = UniAppDatabase.getDatabase(application).okulDao()
        verileriOku = okulDao.veriOku()
    }

    fun okulEkle(okul: OkulTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            okulDao.okulEkle(okul)
        }
    }

    suspend fun bolumeGoreGetir(bolum: String): List<OkulTablosu> {
        return okulDao.bolumeGoreGetir(bolum)
    }

    suspend fun ileGoreGetir(il: String): List<OkulTablosu> {
        return okulDao.ileGoreGetir(il)
    }
}
