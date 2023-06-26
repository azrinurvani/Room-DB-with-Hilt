package com.azrinurvani.mobile.roomdb.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azrinurvani.mobile.roomdb.data.RoomWordDataSource
import com.azrinurvani.mobile.roomdb.data.WordDatabase
import com.azrinurvani.mobile.roomdb.data.WordLocalDataSource
import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.migrations.migration2To3
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideWordDatabase(@ApplicationContext context: Context) : WordDatabase{
        return Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            "word.db"
        ).addMigrations(migration2To3)
            .build()
    }

    @Provides
    fun provideWordDao(wordDatabase: WordDatabase) : WordDao{
        return wordDatabase.wordDao()
    }

    @Provides
    fun provideLocalWordDataSource(wordDao: WordDao): WordLocalDataSource{
        return RoomWordDataSource(wordDao)
    }
}