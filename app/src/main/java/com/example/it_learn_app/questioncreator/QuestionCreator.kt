package com.example.it_learn_app.questioncreator

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import com.example.it_learn_app.repositorys.UserSettingsDataRepository
import kotlinx.coroutines.CoroutineScope

public interface QuestionCreator {
   fun <T>setQuestionSettings(settings: T)
    fun createQuestion() : Quest
}