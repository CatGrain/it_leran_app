package com.example.it_learn_app.model.question.creator

import com.example.it_learn_app.model.question.base.IQuestionCreator
import com.example.it_learn_app.model.question.base.Question

class ExampleQuestionCreator : IQuestionCreator  {

    override fun createQuestion(): Question {
        return Question("Test Example Question", "Test Example Answer ")
    }
}