package com.example.uniapp.data.gecmisgidilenler

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.uniapp.data.kisi.KisiTablosu
import com.example.uniapp.data.etkinlik.EtkinlikTablosu

@Entity(
    tableName = "gecmis_gidilenler_tablosu",
    foreignKeys = [
        ForeignKey(
            entity = KisiTablosu::class,
            parentColumns = ["kisi_id"],
            childColumns = ["kisi_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EtkinlikTablosu::class,
            parentColumns = ["etkinlik_id"],
            childColumns = ["etkinlik_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class GecmisGidilenlerTablosu(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gecmis_id")
    var gecmisId: Int = 0,

    @ColumnInfo(name = "kisi_id", index = true)
    var kisiId: Int,

    @ColumnInfo(name = "etkinlik_id", index = true)
    var etkinlikId: Int
)
