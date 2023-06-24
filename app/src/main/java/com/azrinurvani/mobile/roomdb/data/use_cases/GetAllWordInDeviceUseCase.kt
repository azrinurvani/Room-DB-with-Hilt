package com.azrinurvani.mobile.roomdb.data.use_cases

import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*TODO - Fungsi penggunaan UseCase adalah agar tidak memanggil repo di ViewModel,
    karena tidak semua repo dibutuhkan pada ViewModel, terutama pada project skala besar
    */
class GetAllWordInDeviceUseCase @Inject constructor(private val wordRepository: WordRepository) {

    operator fun invoke() : Flow<List<Word>> {
        return wordRepository.getAllWords()
    }
}