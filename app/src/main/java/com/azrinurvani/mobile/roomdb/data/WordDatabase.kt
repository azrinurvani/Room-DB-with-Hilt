package com.azrinurvani.mobile.roomdb.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.azrinurvani.mobile.roomdb.data.converters.RoomConverters
import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.migrations.Migration1To2
import com.azrinurvani.mobile.roomdb.data.models.Word

@Database(
    entities = [Word::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2, spec = Migration1To2::class)
    ]
)
@TypeConverters(RoomConverters::class)
abstract class WordDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

/*TODO - Move to DI module*/

//    companion object{
//        private fun buildDatabase(context : Context) : WordDatabase {
//            return Room.databaseBuilder(
//                context,
//                WordDatabase::class.java,
//                "word.db"
//            ).build()
//        }
//
//        @Volatile
//        private var INSTANCE : WordDatabase? = null
//
//        fun getDatabaseInstance(context: Context) : WordDatabase{
//            if (INSTANCE == null){
//                INSTANCE = buildDatabase(context)
//            }
//            return INSTANCE as WordDatabase
//        }
//
//    }

}