package com.example.uniapp.data.favoriler

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavorilerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun favoriEkle(favori: FavorilerTablosu)

    @Query("SELECT * FROM favoriler_tablo WHERE kisi_id = :kisiId")
    fun kisiFavorileriniGetir(kisiId: Int): LiveData<List<FavorilerTablosu>>

    // İleride bir favoriyi silmek için bu fonksiyonu kullanabilirsiniz.
    // @Query("DELETE FROM favoriler_tablo WHERE etkinlik_id = :etkinlikId AND kisi_id = :kisiId")
    // suspend fun favoriSil(etkinlikId: Int, kisiId: Int)
}
