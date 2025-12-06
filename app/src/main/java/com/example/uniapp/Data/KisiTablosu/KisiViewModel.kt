package com.example.uniapp.Data.KisiTablosu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uniapp.Data.KisiRepository
import com.example.uniapp.Data.KisiVeritabani
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiViewModel(application: Application): AndroidViewModel(application){

    private val verileriOku: LiveData<List<KisiTablo>>
    private val repository: KisiRepository

    init {
        val KisiDao = KisiVeritabani.Companion.getDatabase(application).kisiDao()
        repository = KisiRepository(KisiDao)
        verileriOku = repository.veriOku
    }

    fun kisiEkle(kisiTablo: KisiTablo){
        viewModelScope.launch(Dispatchers.IO){
            repository.kisiEkleme(kisiTablo)
        }
    }

    fun verioku(kisiTablo: KisiTablo){
        viewModelScope.launch { Dispatchers.IO
        repository.veriokuma(kisiTablo)
        }
    }

    suspend fun sifrekontrol(kullanici_isim: String): KisiTablo?{
        return repository.sifrekontrol(kullanici_isim)
    }
}