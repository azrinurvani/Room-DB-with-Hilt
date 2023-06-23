package com.azrinurvani.mobile.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.azrinurvani.mobile.roomdb.data.ViewModelFactory
import com.azrinurvani.mobile.roomdb.data.WordDatabase
import com.azrinurvani.mobile.roomdb.data.WordRepository
import com.azrinurvani.mobile.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(WordRepository(WordDatabase.getDatabaseInstance(this)))
        )[MainViewModel::class.java]
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
        viewModel.getAllWords().observe(this){
            println(it)
        }
    }

    private fun listener(){
        binding.apply {
            btnInsert.setOnClickListener {
                viewModel.addWord(etWord.text.toString())
            }

        }
    }
}
