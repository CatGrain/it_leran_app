package com.example.it_learn_app.quizGame

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.it_learn_app.R
import com.example.it_learn_app.databinding.ActivityMainBinding
import com.example.it_learn_app.databinding.FragmentQuizOverviewBinding
import com.example.it_learn_app.model.GameStateViewModel
import com.example.it_learn_app.model.QuestionManagerViewModel


class quizGame : Fragment(){

    private lateinit var quizOverwiewBinding: FragmentQuizOverviewBinding
    // ViewModels
    private val gameStateViewModel: GameStateViewModel by viewModels()
    private val questionManagerViewModel: QuestionManagerViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        quizOverwiewBinding = FragmentQuizOverviewBinding.inflate(inflater,container,false).apply {
            questionManagerViewModel = this@quizGame.questionManagerViewModel
            lifecycleOwner = this@quizGame
        }

        return quizOverwiewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quizOverwiewBinding.enterButton.setOnClickListener{
            gameStateViewModel.updateState()
        }
        gameStateViewModel.curentGameState.observe(this.viewLifecycleOwner){
            updateUi(it)
        }
        setUpSettingsNavigation()
    }

    private fun setUpSettingsNavigation(){
        gameStateViewModel.onNavigateToSettings.observe(viewLifecycleOwner){

        }
    }

    private fun navigateToSettings(){

    }

    fun updateUi(gameState: GameStateViewModel.GameState) {
        when (gameState) {
            GameStateViewModel.GameState.UPDATEQUESTION -> {
                questionManagerViewModel.nextQuest()
                gameStateViewModel.updateState()
            }

            GameStateViewModel.GameState.ANSWERQUESTION -> {
                quizOverwiewBinding.questionAnswer.setEnabled(true)
                setInputFieldFocus()
            }

            GameStateViewModel.GameState.CHECKANSWER -> {
                quizOverwiewBinding.questionAnswer.setEnabled(false)
                checkQuestion()
            }

            GameStateViewModel.GameState.RESETQUIZ -> {
                quizOverwiewBinding.questionAnswerResult.text = ""
                quizOverwiewBinding.questionAnswer.text.clear()
                gameStateViewModel.updateState()
            }
        }
    }

    fun setInputFieldFocus() {
        Context.INPUT_METHOD_SERVICE
        quizOverwiewBinding.questionAnswer.requestFocus()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(quizOverwiewBinding.questionAnswer, InputMethodManager.SHOW_IMPLICIT)
    }

    fun checkQuestion() {
        val corectAnswer = questionManagerViewModel.curentQuest.value!!.answer
        if (questionManagerViewModel.checkAnswer(quizOverwiewBinding.questionAnswer.text.toString())) {
            showGameMesage(Color.GREEN, getString(R.string.right_answer, corectAnswer))
        } else {
            showGameMesage(Color.RED, getString(R.string.wrong_answer_message, corectAnswer))
        }
    }

    fun showGameMesage(color: Int, mesage: String) {
        quizOverwiewBinding.questionAnswerResult.setTextColor(color)
        quizOverwiewBinding.questionAnswerResult.text = mesage
    }
}