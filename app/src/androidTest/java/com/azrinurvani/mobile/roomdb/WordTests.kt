package com.azrinurvani.mobile.roomdb

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.azrinurvani.mobile.roomdb.data.WordDatabase
import com.azrinurvani.mobile.roomdb.data.daos.WordDao
import com.azrinurvani.mobile.roomdb.data.models.Word
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WordTests {


    private lateinit var wordDatabase: WordDatabase
    private lateinit var wordDao: WordDao

    @Before
    fun setUp(){
        //is not actually database, just in memory
        wordDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WordDatabase::class.java
        ).build()
        wordDao = wordDatabase.wordDao()
    }

    @Test
    fun afterInsertingOneWord_mustSeeThatWord()  = runBlocking {
        wordDao.insertWord(Word(word="abc"))
        val words = wordDao.getAllWordsTest()

        assertEquals(1,words.size)
        assertEquals("abc",words[0].word)
    }

    @Test
    fun afterInsertingManyWord_ResultMustBeSort()  = runBlocking {
        wordDao.insertWord(Word(word="abc"))
        wordDao.insertWord(Word(word="bbc"))
        wordDao.insertWord(Word(word="dddeq"))
        wordDao.insertWord(Word(word="qeqeq"))

        val words = wordDao.getAlphabeticallySort()
        assertEquals(4,words.size)
        assertEquals("abc",words[0].word)
        assertEquals("bbc",words[1].word)
        assertEquals("dddeq",words[2].word)
        assertEquals("qeqeq",words[3].word)
    }

    @After
    fun tearDown() {
        wordDatabase.close()
    }


}