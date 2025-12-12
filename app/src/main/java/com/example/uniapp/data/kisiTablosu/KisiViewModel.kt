package com.example.uniapp.data.kisiTablosu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.data.database.UniAppDatabase
import com.example.uniapp.data.kisi.KisiTablosu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiViewModel(application: Application): AndroidViewModel(application) {
    private val verileriOku: LiveData<List<KisiTablosu>>
    private val repository: KisiRepository

    init {
        val KisiDao = UniAppDatabase.Companion.getDatabase(application).kisiDao()
        repository = KisiRepository(KisiDao)
        verileriOku = repository.veriOku
    }

    fun kisiEkle(kisiTablo: KisiTablosu){
        viewModelScope.launch(Dispatchers.IO){
            repository.kisiEkleme(kisiTablo)
        }
    }

    fun verioku(kisiTablo: KisiTablosu){
        viewModelScope.launch (Dispatchers.IO){
            repository.veriokuma(kisiTablo)
        }
    }

    suspend fun sifrekontrol(kullanici_isim: String): KisiTablosu?{
        return repository.sifrekontrol(kullanici_isim)
    }
}