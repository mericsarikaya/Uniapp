package com.example.uniapp.data.bolum

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BolumViewModel(application: Application) : AndroidViewModel(application) {

    val tumBolumler: LiveData<List<BolumTablosu>>
    private val bolumDao: BolumDao

    init {
        bolumDao = UniAppDatabase.getDatabase(application).bolumDao()
        tumBolumler = bolumDao.tumBolumleriGetir()
    }

    fun bolumEkle(bolum: BolumTablosu) {
        viewModelScope.launch(Dispatchers.IO) {
            bolumDao.bolumEkle(bolum)
        }
    }

    fun okulaGoreBolumleriGetir(secilenOkulId: Int): LiveData<List<BolumTablosu>> {
        return bolumDao.okulaGoreBolumleriGetir(secilenOkulId)
    }
}
