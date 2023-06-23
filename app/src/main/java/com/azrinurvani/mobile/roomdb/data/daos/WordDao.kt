package com.azrinurvani.mobile.roomdb.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word) : Long

    @Insert
    suspend fun insertWords(word: List<Word>) : List<Long>

    @Delete
    suspend fun removeWord(word: List<Word>) : Int

    @Update(onConflict = OnConflictStrategy.ABORT)
    suspend fun updateWord(word: Word) : Int

    @Query("SELECT * FROM word_table")
    fun getAllWords() : Flow<List<Word>>


}