package com.example.it_learn_app.data

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import com.example.it_learn_app.questioncreator.BinaryQuestionCreator

object QuizDataSource {
    val quizSource: List<QuizData> = listOf(
        QuizData(
            "Binary to Dezimal",
            "any description",
            BinaryQuestionCreator(2),
            QuizSettingsData(
                UserSettings.BINARY_QUESTION_RANGE
            )
        ),

        QuizData(
            "Hexa to Dezimal",
            "any description",
            BinaryQuestionCreator(16),
            QuizSettingsData(
                UserSettings.HEXA_QUESTION_RANGE
            )
        ),

        QuizData(
            "Okta to Dezimal",
            "any description",
            BinaryQuestionCreator(8),
            QuizSettingsData(
                UserSettings.OKTAL_QUESTION_RANGE
            )
        )
    )
}