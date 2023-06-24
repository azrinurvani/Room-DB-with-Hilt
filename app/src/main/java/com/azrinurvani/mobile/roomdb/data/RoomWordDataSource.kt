package com.azrinurvani.mobile.roomdb.data

import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomWordDataSource @Inject constructor(private val wordDao: WordDao) : WordLocalDataSource {
    override fun getAllWords(): Flow<List<Word>> {
        return wordDao.getAllWords()
    }

    override suspend fun insertWord(word: Word): Long {
        return wordDao.insertWord(word)
    }
}