package com.example.it_learn_app.model

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.it_learn_app.questioncreator.BinaryQuestionCreator
import com.example.it_learn_app.questioncreator.Quest
import com.example.it_learn_app.questioncreator.QuestionCreator


class QuestionManagerViewModel : ViewModel() {

    private var _curentQuest = MutableLiveData<Quest>()
    var curentQuest:LiveData<Quest> = _curentQuest

    private lateinit var _curentQuestCreator:QuestionCreator

    fun setQuestData(questionCreator: QuestionCreator){
        _curentQuestCreator = questionCreator
    }

    fun nextQuest(){
        _curentQuest.value = _curentQuestCreator.createQuestion()
    }

    fun checkAnswer(answer:String):Boolean{
        return _curentQuest.value!!.answer == answer
    }
}