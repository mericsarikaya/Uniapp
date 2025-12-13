package com.example.uniapp.data.SehirTablosu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.data.sehir.SehirTablosu

@Dao
interface SehirDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun sehirEkle(sehir: SehirTablosu)

    @Query("SELECT * FROM sehir_tablosu ORDER BY ad ASC")
    fun tumSehirleriGetir(): LiveData<List<SehirTablosu>>
}
