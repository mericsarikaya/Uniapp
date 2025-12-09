package com.example.uniapp.Data.KisiTablosu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.Data.KisiTablosu.KisiTablo

@Dao
interface KisiDao {
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    fun kisiEkle(kisiTablo: KisiTablo)

    @Query("Select * From Kisi ORDER BY id ASC")
    fun veriOku(): LiveData<List<KisiTablo>>

    @Query("select * from Kisi where mail = :kullanici_isim")
    suspend fun sifreKontrol(kullanici_isim: String): KisiTablo?
}