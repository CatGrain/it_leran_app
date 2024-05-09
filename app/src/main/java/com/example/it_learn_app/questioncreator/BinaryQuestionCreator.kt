package com.example.it_learn_app.questioncreator

class BinaryQuestionCreator(var from:Int , var  to:Int,var base:Int) : QuestionCreator {
    override fun createQuestion() : Quest {
        val number:Int = (from..to).random()
        val numberInBinary:String = number.toString(base)
        return Quest(numberInBinary,number.toString())
    }
}