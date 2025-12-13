package com.example.uniapp.data.BolumTablosu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.data.bolum.BolumTablosu

@Dao
interface BolumDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun bolumEkle(bolum: BolumTablosu)

    @Query("SELECT * FROM bolum_tablosu ORDER BY bolum_id ASC")
    fun tumBolumleriGetir(): LiveData<List<BolumTablosu>>

    @Query("SELECT * FROM bolum_tablosu WHERE okul_id = :secilenOkulId")
    fun okulaGoreBolumleriGetir(secilenOkulId: Int): LiveData<List<BolumTablosu>>

    @Query("SELECT * FROM bolum_tablosu WHERE bolum_adi = :arananBolumAdi LIMIT 1")
    suspend fun adaGoreGetir(arananBolumAdi: String): BolumTablosu?
}
