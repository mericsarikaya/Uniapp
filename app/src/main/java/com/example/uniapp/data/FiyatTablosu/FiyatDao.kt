package com.example.uniapp.data.FiyatTablosu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.data.fiyat.FiyatTablosu

@Dao
interface FiyatDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun fiyatEkle(fiyat: FiyatTablosu)

    @Query("SELECT * FROM fiyat_tablosu ORDER BY fiyat_id ASC")
    fun tumFiyatlariGetir(): LiveData<List<FiyatTablosu>>
}
