package com.example.it_learn_app.data
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey

enum class UserSettings(key:String) {
    BINARY_QUESTION_RANGE ("binary_question_range"),
    HEXA_QUESTION_RANGE ("hexa_question_range"),
    OKTAL_QUESTION_RANGE ("oktal_question_range")
}