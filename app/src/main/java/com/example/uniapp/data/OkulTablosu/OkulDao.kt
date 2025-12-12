package com.example.uniapp.data.okul

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OkulDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun okulEkle(okul: OkulTablosu)

    @Query("SELECT * FROM okul_tablosu ORDER BY okul_id ASC")
    fun veriOku(): LiveData<List<OkulTablosu>>

    @Query("SELECT * FROM okul_tablosu WHERE bolum = :arananBolum")
    suspend fun bolumeGoreGetir(arananBolum: String): List<OkulTablosu>

    @Query("SELECT * FROM okul_tablosu WHERE il = :arananIl")
    suspend fun ileGoreGetir(arananIl: String): List<OkulTablosu>
}
