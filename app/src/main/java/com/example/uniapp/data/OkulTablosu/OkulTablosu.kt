package com.example.uniapp.data.okul

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "okul_tablosu")
data class OkulTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "okul_id")
    var okulId: Int = 0,

    @ColumnInfo(name = "bolum")
    var bolum: String,

    @ColumnInfo(name = "il")
    var il: String
)
