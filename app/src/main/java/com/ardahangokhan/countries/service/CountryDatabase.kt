package com.ardahangokhan.countries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ardahangokhan.countries.model.Country

@Database(entities = arrayOf(Country::class), version = 1)
abstract class CountryDatabase :RoomDatabase(){
    abstract fun countryDao(): CountryDao

    //Singleton yapısı oluşturuyoruz diyebiliriz aslında. bu işlem 1 kez bir öğe oluşturur, eğer daha önce oluşturulduysa yeniden oluşturulmaz

    companion object {
        @Volatile
        private var instance: CountryDatabase? = null
        //volatile diğer theread lere görünür hale getiriyor

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            //instance varsa instance döndürülecek yoksa senkronize bir şekilde lock dönecek

            instance ?: makeDatabase(context).also {
                instance =it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, CountryDatabase::class.java, "countrydatabase"
        ).build()
    }
}