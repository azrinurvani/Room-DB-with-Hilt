package com.azrinurvani.mobile.roomdb.data

import com.azrinurvani.mobile.roomdb.data.models.Word

class WordRepository (private val wordDatabase: WordDatabase){

    suspend fun insertWord(word : Word){
        wordDatabase.wordDao().insertWord(word)
    }

    fun getAllWords() = wordDatabase.wordDao().getAllWords()

}