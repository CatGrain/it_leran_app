package com.example.it_learn_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.constraintlayout.motion.utils.ViewState
import com.example.it_learn_app.databinding.ActivityMainBinding
import com.example.it_learn_app.model.QuestionManager


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val questionManager: QuestionManager = QuestionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.enterButton.setOnClickListener {


            
        }
    }

    private fun isAnswerCorect(): Boolean{
        if(questionManager.curentQuestion.answer == binding.questionAnswer.text.toString())
            return  true

        return  false
    }
}


