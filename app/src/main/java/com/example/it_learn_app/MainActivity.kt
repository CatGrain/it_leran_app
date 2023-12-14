package com.example.it_learn_app

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.it_learn_app.databinding.ActivityMainBinding
import com.example.it_learn_app.model.GameStateViewModel
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.it_learn_app.model.QuestionManagerViewModel

var randomValue = (1..10).random()


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    // ViewModels
    private val gameStateViewModel: GameStateViewModel by viewModels()
    private val questionManagerViewModel:QuestionManagerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize UI
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.questionManagerViewModel = questionManagerViewModel

        gameStateViewModel.curentGameState.observe(this, Observer { updateUi(it) })
        activityMainBinding.enterButton.setOnClickListener{gameStateViewModel.updateState()}
    }

    fun updateUi(gameState:GameStateViewModel.GameState){
        when(gameState){
            GameStateViewModel.GameState.UPDATEQUESTION -> {
                questionManagerViewModel.nextQuest()
                gameStateViewModel.updateState()
            }
            GameStateViewModel.GameState.ANSWERQUESTION -> {
                activityMainBinding.questionAnswer.setEnabled(true)
                setInputFieldFocus()
            }
            GameStateViewModel.GameState.CHECKANSWER -> {
                activityMainBinding.questionAnswer.setEnabled(false)
                checkQuestion()
            }
            GameStateViewModel.GameState.RESETQUIZ ->{
                activityMainBinding.questionAnswerResult.text = ""
                activityMainBinding.questionAnswer.text.clear()
                gameStateViewModel.updateState()
            }
        }
    }

    fun setInputFieldFocus(){
        activityMainBinding.questionAnswer.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(activityMainBinding.questionAnswer, InputMethodManager.SHOW_IMPLICIT)
    }

    fun checkQuestion(){
        val corectAnswer = questionManagerViewModel.curentQuest.value!!.answer
        if(questionManagerViewModel.checkAnswer(activityMainBinding.questionAnswer.text.toString())){
            showGameMesage(Color.GREEN,getString(R.string.right_answer,corectAnswer))
        }
        else
        {
            showGameMesage(Color.RED,getString(R.string.wrong_answer_message,corectAnswer))
        }
    }

    fun showGameMesage(color:Int, mesage:String){
        activityMainBinding.questionAnswerResult.setTextColor(color)
        activityMainBinding.questionAnswerResult.text = mesage
    }
}

