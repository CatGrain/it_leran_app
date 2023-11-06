package com.example.it_learn_app.model.question

import com.example.it_learn_app.model.question.base.IQuestionCreator
import com.example.it_learn_app.model.question.base.Question
import com.example.it_learn_app.model.question.creator.ExampleQuestionCreator

class QuestionGeter {

    public fun getQuestion(): Question {
        return ExampleQuestionCreator().createQuestion()
    }
}