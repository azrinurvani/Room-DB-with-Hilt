package com.azrinurvani.mobile.roomdb.data

import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.models.Word
import javax.inject.Inject

class WordRepository @Inject constructor(private val localDataSource: RoomWordDataSource){

    suspend fun insertWord(word : Word){
        localDataSource.insertWord(word)
    }

    fun getAllWords() = localDataSource.getAllWords()

}