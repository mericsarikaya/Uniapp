package com.example.uniapp.data.kisi

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KisiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun kisiEkle(kisi: KisiTablosu)

    @Query("SELECT * FROM kisi_tablosu ORDER BY kisi_id ASC")
    fun veriOku(): LiveData<List<KisiTablosu>>

    @Query("SELECT * FROM kisi_tablosu WHERE isim = :kullaniciIsim LIMIT 1")
    suspend fun sifreKontrol(kullaniciIsim: String): KisiTablosu?
}
