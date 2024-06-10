package com.example.it_learn_app.model

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldiNord.customerfeedbackpoc.wrappers.Event
import com.example.it_learn_app.data.QuizData

class GameStateViewModel : ViewModel() {
    enum class GameState {
        UPDATEQUESTION,
        ANSWERQUESTION,
        CHECKANSWER,
        RESETQUIZ
    }

    private val _curentGameState = MutableLiveData<GameState>()
    var curentGameState : LiveData<GameState> = _curentGameState

    private val _onNavigateToSettings:MutableLiveData<QuizData> = MutableLiveData()
    val onNavigateToSettings:LiveData<QuizData> = _onNavigateToSettings

    fun onOpenSettingsMask(data: QuizData) {
        _onNavigateToSettings.value = data
    }

    init {
        _curentGameState.value = GameState.UPDATEQUESTION
    }

    public fun updateState(){
        when(_curentGameState.value){
            GameState.UPDATEQUESTION -> _curentGameState.value = GameState.ANSWERQUESTION
            GameState.ANSWERQUESTION -> _curentGameState.value = GameState.CHECKANSWER
            GameState.CHECKANSWER -> _curentGameState.value = GameState.RESETQUIZ
            else -> _curentGameState.value = GameState.UPDATEQUESTION
        }
    }
}

