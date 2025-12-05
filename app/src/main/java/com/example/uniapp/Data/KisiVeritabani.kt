package com.example.uniapp.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uniapp.Data.KisiTablosu.KisiDao
import com.example.uniapp.Data.KisiTablosu.KisiTablo
import java.time.Instant

@Database(entities = [KisiTablo::class], version = 1, exportSchema = false)
abstract class KisiVeritabani: RoomDatabase() {

    abstract fun kisiDao(): KisiDao

    companion object{
        @Volatile
        private var INSTANCE: KisiVeritabani? = null

        fun getDatabase(context: Context): KisiVeritabani{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized (this ){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KisiVeritabani::class.java,
                    "kisi_veritabani"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}