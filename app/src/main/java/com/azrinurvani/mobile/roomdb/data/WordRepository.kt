package com.azrinurvani.mobile.roomdb.data

import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.models.Word
import javax.inject.Inject

class WordRepository @Inject constructor(private val wordDao: WordDao){

    suspend fun insertWord(word : Word){
        wordDao.insertWord(word)
    }

    fun getAllWords() = wordDao.getAllWords()

}