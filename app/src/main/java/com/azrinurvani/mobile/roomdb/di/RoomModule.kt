package com.azrinurvani.mobile.roomdb.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azrinurvani.mobile.roomdb.data.WordDatabase
import com.azrinurvani.mobile.roomdb.data.daos.WordDao
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
        ).build()
    }

    @Provides
    fun provideWordDao(wordDatabase: WordDatabase) : WordDao{
        return wordDatabase.wordDao()
    }
}