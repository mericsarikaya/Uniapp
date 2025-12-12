package com.example.uniapp.data.etkinlik

import androidx.lifecycle.LiveData
import com.example.uniapp.data.etkinlik.etkinlik

class EtkinlikRepository (private val etkinlikDao: EtkinlikDao){
    val verioku: LiveData<List<etkinlik>> = etkinlikDao.etkinlikverisioku()
    fun etkinlikekleme(etkinlik: etkinlik){
        etkinlikDao.etkinlikekle(etkinlik)
    }
    fun veriokuma(etkinlik: etkinlik){
        etkinlikDao.etkinlikverisioku()
    }
}