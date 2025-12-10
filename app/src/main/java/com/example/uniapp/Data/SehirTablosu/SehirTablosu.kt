package com.example.uniapp.data.sehir

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sehir_tablosu")
data class SehirTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "sehir_id")
    var sehirId: Int = 0,

    @ColumnInfo(name = "ad")
    var ad: String
)
