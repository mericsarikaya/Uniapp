package com.example.uniapp.data.gecmisgidilenler

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GecmisGidilenlerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun gidilenEkle(gecmisGidilenler: GecmisGidilenlerTablosu)

    @Query("SELECT * FROM gecmis_gidilenler_tablosu WHERE kisi_id = :kisiId")
    fun kisiGecmisiniGetir(kisiId: Int): LiveData<List<GecmisGidilenlerTablosu>>
}
