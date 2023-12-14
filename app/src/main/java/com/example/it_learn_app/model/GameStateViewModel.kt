package com.example.it_learn_app.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameStateViewModel : ViewModel() {
    enum class GameState {
        UPDATEQUESTION,
        ANSWERQUESTION,
        CHECKANSWER,
        RESETQUIZ
    }

    private val _curentGameState = MutableLiveData<GameState>()
    var curentGameState : LiveData<GameState> = _curentGameState


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

