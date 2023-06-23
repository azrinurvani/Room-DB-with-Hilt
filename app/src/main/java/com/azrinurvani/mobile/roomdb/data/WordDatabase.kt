package com.azrinurvani.mobile.roomdb.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.azrinurvani.mobile.roomdb.data.converters.RoomConverters
import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.models.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao


    companion object{
        private fun buildDatabase(context : Context) : WordDatabase {
            return Room.databaseBuilder(
                context,
                WordDatabase::class.java,
                "word.db"
            ).build()
        }

        @Volatile
        private var INSTANCE : WordDatabase? = null

        fun getDatabaseInstance(context: Context) : WordDatabase{
            if (INSTANCE == null){
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE as WordDatabase
        }

    }

}