package com.example.uniapp.data.kisi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kisi_tablosu")
data class KisiTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisi_id")
    var kisiId: Int = 0,

    @ColumnInfo(name = "isim")
    var isim: String,

    @ColumnInfo(name = "soyisim")
    var soyisim: String,

    @ColumnInfo(name = "mail")
    var mail: String,

    @ColumnInfo(name = "telefon_numarasi")
    var telefonNumarasi: String,

    @ColumnInfo(name = "dogum_tarihi")
    var dogumTarihi: String,

    @ColumnInfo(name = "sifre")
    var sifre: String
)
