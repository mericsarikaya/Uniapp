package com.example.uniapp.data.etkinlik

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EtkinlikDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun etkinlikEkle(etkinlik: EtkinlikTablosu)

    @Query("SELECT * FROM etkinlik_tablo ORDER BY etkinlik_id ASC")
    fun tumEtkinlikleriGetir(): LiveData<List<EtkinlikTablosu>>
}
