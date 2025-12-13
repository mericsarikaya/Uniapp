package com.example.uniapp.data.EtkinlikTablosu

import androidx.lifecycle.LiveData
import com.example.uniapp.data.etkinlik.etkinlik

class EtkinlikRepository(private val etkinlikDao: EtkinlikDao) {

    val tumEtkinlikler: LiveData<List<etkinlik>> = etkinlikDao.etkinlikverisioku()

    suspend fun etkinlikEkle(etkinlik: etkinlik) {
        etkinlikDao.etkinlikekle(etkinlik)
    }

    fun etkinlikVerisiOku(): LiveData<List<etkinlik>> {
        return etkinlikDao.etkinlikverisioku()
    }
}
