package com.example.uniapp.Data.KisiTablosu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Kisi")
class KisiTablo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "isim") var isim: String,
    @ColumnInfo(name = "soyisim") var soyisim: String,
    @ColumnInfo(name = "mail") var mail: String,
    @ColumnInfo(name = "telefon") var telefon_numarası: String,
    @ColumnInfo(name = "doğum_tarihi") var dogum_tarihi: String,
    @ColumnInfo(name = "sifre") var sifre: String
)
{

}