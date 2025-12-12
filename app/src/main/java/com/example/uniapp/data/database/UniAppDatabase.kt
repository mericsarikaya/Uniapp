package com.example.uniapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uniapp.data.biletlertablosu.BiletDao
import com.example.uniapp.data.biletlertablosu.BiletView
import com.example.uniapp.data.bolum.BolumDao
import com.example.uniapp.data.bolum.BolumTablosu
import com.example.uniapp.data.etkinlik.EtkinlikDao
import com.example.uniapp.data.etkinlik.etkinlik
import com.example.uniapp.data.favoriler.FavorilerDao
import com.example.uniapp.data.favoriler.FavorilerTablosu
import com.example.uniapp.data.fiyat.FiyatDao
import com.example.uniapp.data.fiyat.FiyatTablosu
import com.example.uniapp.data.gecmisgidilenler.GecmisGidilenlerDao
import com.example.uniapp.data.gecmisgidilenler.GecmisGidilenlerTablosu
import com.example.uniapp.data.kisi.KisiDao
import com.example.uniapp.data.kisi.KisiTablosu
import com.example.uniapp.data.okul.OkulDao
import com.example.uniapp.data.okul.OkulTablosu
import com.example.uniapp.data.sehir.SehirDao
import com.example.uniapp.data.sehir.SehirTablosu

@Database(
    entities = [
        KisiTablosu::class,
        OkulTablosu::class,
        BolumTablosu::class,
        etkinlik::class,
        FavorilerTablosu::class,
        SehirTablosu::class,
        FiyatTablosu::class,
        GecmisGidilenlerTablosu::class
    ],
    views = [BiletView::class],
    version = 3,
    exportSchema = false
)
abstract class UniAppDatabase : RoomDatabase() {

    abstract fun kisiDao(): KisiDao
    abstract fun okulDao(): OkulDao
    abstract fun bolumDao(): BolumDao
    abstract fun etkinlikDao(): EtkinlikDao
    abstract fun favorilerDao(): FavorilerDao
    abstract fun sehirDao(): SehirDao
    abstract fun fiyatDao(): FiyatDao
    abstract fun gecmisGidilenlerDao(): GecmisGidilenlerDao
    abstract fun biletDao(): BiletDao

    companion object {
        @Volatile
        private var INSTANCE: UniAppDatabase? = null

        fun getDatabase(context: Context): UniAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UniAppDatabase::class.java,
                    "uniapp_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
