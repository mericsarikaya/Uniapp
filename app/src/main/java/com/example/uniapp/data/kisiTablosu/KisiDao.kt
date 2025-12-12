package com.example.uniapp.data.kisi

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KisiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun kisiEkle(kisi: KisiTablosu)

    @Query("SELECT * FROM kisi_tablosu ORDER BY kisi_id ASC")
    fun veriOku(): LiveData<List<KisiTablosu>>

    @Query("SELECT * FROM kisi_tablosu WHERE mail = :kullaniciisim LIMIT 1")
    suspend fun sifreKontrol(kullaniciisim: String): KisiTablosu?
}
