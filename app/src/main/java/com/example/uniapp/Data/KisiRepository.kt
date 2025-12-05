package com.example.uniapp.Data

import androidx.lifecycle.LiveData
import com.example.uniapp.Data.KisiTablosu.KisiDao
import com.example.uniapp.Data.KisiTablosu.KisiTablo

class KisiRepository(private val kisiDao: KisiDao){

    val veriOku: LiveData<List<KisiTablo>> = kisiDao.veriOku()

    fun kisiEkleme(kisiTablo: KisiTablo){
        kisiDao.kisiEkle(kisiTablo)
    }
}