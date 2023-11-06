package com.example.it_learn_app.model

import com.example.it_learn_app.model.question.QuestionGeter
import com.example.it_learn_app.model.question.base.Question

public class QuestionManager {
    lateinit var curentQuestion: Question
    private val questionGeter: QuestionGeter = QuestionGeter()

    public fun nextQuestion(){
        curentQuestion = questionGeter.getQuestion()
    }
}


