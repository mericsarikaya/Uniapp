package com.example.uniapp.data.fiyat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fiyat_tablosu")
data class FiyatTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fiyat_id")
    var fiyatId: Int = 0,

    @ColumnInfo(name = "indirim_kodu")
    var indirimKodu: String?,

    @ColumnInfo(name = "indirim_yuzdesi")
    var indirimYuzdesi: Int?,

    @ColumnInfo(name = "fiyat")
    var fiyat: Double
)
