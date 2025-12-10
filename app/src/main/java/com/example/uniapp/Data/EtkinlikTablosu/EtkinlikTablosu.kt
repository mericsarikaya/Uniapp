package com.example.uniapp.data.etkinlik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.uniapp.data.fiyat.FiyatTablosu
import com.example.uniapp.data.sehir.SehirTablosu

@Entity(
    tableName = "etkinlik_tablosu",
    foreignKeys = [
        ForeignKey(
            entity = SehirTablosu::class,
            parentColumns = ["sehir_id"],
            childColumns = ["sehir_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = FiyatTablosu::class,
            parentColumns = ["fiyat_id"],
            childColumns = ["fiyat_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EtkinlikTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "etkinlik_id")
    var etkinlikId: Int = 0,

    @ColumnInfo(name = "ad")
    var ad: String,

    @ColumnInfo(name = "sehir_id", index = true)
    var sehirId: Int,

    @ColumnInfo(name = "mekan")
    var mekan: String,

    @ColumnInfo(name = "zaman")
    var zaman: String,

    @ColumnInfo(name = "kontenjan")
    var kontenjan: Int,

    @ColumnInfo(name = "aciklama")
    var aciklama: String,

    @ColumnInfo(name = "fiyat_id", index = true)
    var fiyatId: Int
)
