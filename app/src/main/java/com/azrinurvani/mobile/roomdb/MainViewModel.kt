package com.azrinurvani.mobile.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.data.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val wordRepository: WordRepository) : ViewModel() {

    fun getAllWords() = wordRepository.getAllWords().asLiveData(viewModelScope.coroutineContext)

    fun addWord(word:String) = viewModelScope.launch {
        val wordObject = Word(word = word)
        wordRepository.insertWord(wordObject)
    }
}