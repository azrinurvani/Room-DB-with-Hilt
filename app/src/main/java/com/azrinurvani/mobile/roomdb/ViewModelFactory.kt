//package com.azrinurvani.mobile.roomdb
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.azrinurvani.mobile.roomdb.data.WordRepository
//import java.lang.IllegalArgumentException
//
//class ViewModelFactory(private val wordRepository: WordRepository) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
//            return MainViewModel(wordRepository) as T
//        }
//
//        throw IllegalArgumentException("Unknown ViewModel class")
//
//    }
//}