package com.example.uniapp.Data.KisiTablosu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Kisi")
class KisiTablo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "İsim") var isim: String,
    @ColumnInfo(name = "Soyisim") var soyiisim: String,
    @ColumnInfo(name = "Mail") var mail: String,
    @ColumnInfo(name = "Telefon Numarası") var telefon_numarası: String,
    @ColumnInfo(name = "Doğum Tarihi") var dogum_tarihi: String
)
{

}