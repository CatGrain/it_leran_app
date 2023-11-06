package com.example.it_learn_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.it_learn_app.model.StateManager.ViewState
import com.example.it_learn_app.databinding.ActivityMainBinding
import com.example.it_learn_app.model.QuestionManager
import com.example.it_learn_app.model.StateManager


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val stateManager = StateManager()
    private val questionManager: QuestionManager = QuestionManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        update()

        binding.enterButton.setOnClickListener {
            update()
        }
    }

    private fun update(){
        stateManager.updateState()

        when (stateManager.getState()) {

            ViewState.ANSWERQUESTION -> {
                questionManager.nextQuestion()
                binding.questionDescription.text = questionManager.curentQuestion.question;
                binding.enterButton.text = "weiter"
                binding.questionAnswerResult.text = ""
            }

            ViewState.QUESTIONRESULT -> {
                if (isAnswerCorect()){
                    binding.questionAnswerResult.text = "Richtig"
                } else {
                    binding.questionAnswerResult.text = questionManager.curentQuestion.answer;
                }
            }

        }
    }

    private fun isAnswerCorect(): Boolean{
        if(questionManager.curentQuestion.answer == binding.questionAnswer.text.toString())
            return  true

        return  false
    }
}


