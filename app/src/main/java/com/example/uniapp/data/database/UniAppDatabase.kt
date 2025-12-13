package com.example.uniapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uniapp.data.BolumTablosu.BolumDao
import com.example.uniapp.data.bolum.BolumTablosu
import com.example.uniapp.data.EtkinlikTablosu.EtkinlikDao
import com.example.uniapp.data.etkinlik.etkinlik
import com.example.uniapp.data.FavorilerTablosu.FavorilerDao
import com.example.uniapp.data.favoriler.FavorilerTablosu
import com.example.uniapp.data.FiyatTablosu.FiyatDao
import com.example.uniapp.data.fiyat.FiyatTablosu
import com.example.uniapp.data.GecmisGidilenlerTablosu.GecmisGidilenlerDao
import com.example.uniapp.data.gecmisgidilenler.GecmisGidilenlerTablosu
import com.example.uniapp.data.kisiTablosu.KisiDao
import com.example.uniapp.data.kisi.KisiTablosu
import com.example.uniapp.data.OkulTablosu.OkulDao
import com.example.uniapp.data.okul.OkulTablosu
import com.example.uniapp.data.SehirTablosu.SehirDao
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
    version = 3, // Sürüm numarasını koruyoruz
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
