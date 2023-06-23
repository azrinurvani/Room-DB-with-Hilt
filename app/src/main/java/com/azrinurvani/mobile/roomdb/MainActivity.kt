package com.azrinurvani.mobile.roomdb

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

import com.azrinurvani.mobile.roomdb.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels<MainViewModel>()
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
