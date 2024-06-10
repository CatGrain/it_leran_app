package com.example.it_learn_app.data

import androidx.datastore.preferences.core.Preferences
import com.example.it_learn_app.questioncreator.QuestionCreator

data class QuizData (
    val name:String,
    val description:String,
    val questionCreator: QuestionCreator,
    val quizSettingsData:QuizSettingsData
)
