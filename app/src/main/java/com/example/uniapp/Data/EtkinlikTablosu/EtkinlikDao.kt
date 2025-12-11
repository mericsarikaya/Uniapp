package com.example.uniapp.Data.Profil

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.data.etkinlik.EtkinlikTablo

@Dao
interface EtkinlikDao{
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    fun etkinlikekle(etkinlikTablo: EtkinlikTablo)

    @Query("Select * From Etkinlik order by etkinlik_id asc")
    fun etkinlikverisioku(): LiveData<List<EtkinlikTablo>>
}