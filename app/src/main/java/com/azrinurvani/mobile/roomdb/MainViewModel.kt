package com.azrinurvani.mobile.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.launch

class MainViewModel(private val wordRepository: WordRepository) : ViewModel() {

    fun getAllWords() = wordRepository.getAllWords().asLiveData(viewModelScope.coroutineContext)

    fun addWord(word:String) = viewModelScope.launch {
        val wordObject = Word(word = word)
        wordRepository.insertWord(wordObject)
    }
}