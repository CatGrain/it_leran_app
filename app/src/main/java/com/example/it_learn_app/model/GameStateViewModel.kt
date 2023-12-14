package com.example.it_learn_app.model

import android.os.Build.VERSION_CODES.Q
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameStateViewModel : ViewModel() {
    enum class GameState {
        QuestionAnswering,
        Question
    }

    private lateinit var _curentGameState : MutableLiveData<GameState>
    val curentGameState: LiveData<GameState>
        get() = _curentGameState

    public fun UpdateState(){
        when(_curentGameState.value){
            GameState.QuestionAnswering -> _curentGameState.value = GameState.Question
            else -> _curentGameState.value = GameState.QuestionAnswering
        }
    }
}

