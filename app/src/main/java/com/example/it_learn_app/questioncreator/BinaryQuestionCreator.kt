package com.example.it_learn_app.questioncreator

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData
import com.example.it_learn_app.repositorys.UserSettingsDataRepository
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.annotations.Debug

class BinaryQuestionCreator(val base: Int) : QuestionCreator {


    override fun <T> setQuestionSettings(settings: T) {
        TODO("Not yet implemented")
    }

    override fun createQuestion(): Quest {
        val number: Int = (0..255).random()
        val numberInBinary: String = number.toString(base)
        return Quest(numberInBinary, number.toString())
    }
}
