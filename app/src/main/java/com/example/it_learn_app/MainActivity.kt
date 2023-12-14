package com.example.it_learn_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.it_learn_app.databinding.ActivityMainBinding
import com.example.it_learn_app.model.GameStateViewModel


var randomValue = (1..10).random()


class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    private val gameStateViewModel: GameStateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        //Initilize Ui
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }
}


