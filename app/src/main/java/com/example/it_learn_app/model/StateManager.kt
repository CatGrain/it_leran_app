package com.example.it_learn_app.model

class StateManager {
    private var viewState: ViewState = ViewState.QUESTIONRESULT

    fun updateState() {
        viewState = when (viewState) {
            ViewState.ANSWERQUESTION -> ViewState.QUESTIONRESULT
            else -> ViewState.ANSWERQUESTION
        }
    }

    public fun getState(): ViewState {
        return viewState
    }

    public enum class ViewState {
        ANSWERQUESTION, QUESTIONRESULT
    }
}

