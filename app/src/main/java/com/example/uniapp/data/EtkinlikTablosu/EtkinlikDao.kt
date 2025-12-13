package com.example.uniapp.data.EtkinlikTablosu

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uniapp.data.etkinlik.etkinlik

@Dao
interface EtkinlikDao{
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    fun etkinlikekle(etkinlik: etkinlik)

    @Query("Select * From Etkinlik order by etkinlik_id asc")
    fun etkinlikverisioku(): LiveData<List<etkinlik>>
}