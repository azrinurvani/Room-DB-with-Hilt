package com.azrinurvani.mobile.roomdb.data.use_cases

import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.data.models.Word
import javax.inject.Inject

/*TODO - Fungsi penggunaan UseCase adalah agar tidak memanggil repo di ViewModel,
    karena tidak semua repo dibutuhkan pada ViewModel, terutama pada project skala besar
    */
class AddWordToDeviceUseCase @Inject constructor(private val wordRepository: WordRepository) {

    suspend operator fun invoke(word: Word){
        return wordRepository.insertWord(word)
    }
}