package com.example.uniapp.data.kisiTablosu

import androidx.lifecycle.LiveData
import com.example.uniapp.data.kisi.KisiDao
import com.example.uniapp.data.kisi.KisiTablosu

class KisiRepository(private val kisiDao: KisiDao){

    val veriOku: LiveData<List<KisiTablosu>> = kisiDao.veriOku()

    fun kisiEkleme(kisiTablo: KisiTablosu){
        kisiDao.kisiEkle(kisiTablo)
    }
    fun veriokuma(kisiTablo: KisiTablosu){
        kisiDao.veriOku()
    }
    suspend fun sifrekontrol(kullanici_isim: String): KisiTablosu?{
        return kisiDao.sifreKontrol(kullanici_isim)
    }
}