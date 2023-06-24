package com.azrinurvani.mobile.roomdb.data

import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.flow.Flow

interface WordLocalDataSource {

    fun getAllWords() : Flow<List<Word>>

    suspend fun insertWord(word: Word) : Long
}