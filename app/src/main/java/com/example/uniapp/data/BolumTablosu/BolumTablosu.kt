package com.example.uniapp.data.bolum

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.uniapp.data.okul.OkulTablosu

@Entity(
    tableName = "bolum_tablosu",
    foreignKeys = [
        ForeignKey(
            entity = OkulTablosu::class,
            parentColumns = ["okul_id"],
            childColumns = ["okul_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BolumTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bolum_id")
    var bolumId: Int = 0,

    @ColumnInfo(name = "okul_id", index = true)
    var okulId: Int,

    @ColumnInfo(name = "bolum_adi")
    var bolumAdi: String
)
