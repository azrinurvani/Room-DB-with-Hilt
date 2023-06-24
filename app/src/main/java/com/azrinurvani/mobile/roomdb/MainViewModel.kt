package com.azrinurvani.mobile.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.data.models.Word
import com.azrinurvani.mobile.roomdb.data.use_cases.AddWordToDeviceUseCase
import com.azrinurvani.mobile.roomdb.data.use_cases.GetAllWordInDeviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val wordRepository: WordRepository,
    private val addWordToDeviceUseCase: AddWordToDeviceUseCase,
    private val getAllWordInDeviceUseCase: GetAllWordInDeviceUseCase,
) : ViewModel() {

//    fun getAllWords() = wordRepository.getAllWords().asLiveData(viewModelScope.coroutineContext)
    fun getAllWords() = getAllWordInDeviceUseCase().asLiveData(viewModelScope.coroutineContext)

//    fun addWord(word:String) = viewModelScope.launch {
//        val wordObject = Word(word = word)
//        wordRepository.insertWord(wordObject)
//    }
    fun addWord(word:String) = viewModelScope.launch {
        addWordToDeviceUseCase(Word(word = word))
    }
}