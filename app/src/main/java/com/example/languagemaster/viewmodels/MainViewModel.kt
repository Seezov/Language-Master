package com.example.languagemaster.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.languagemaster.utils.TranslationUtils

class MainViewModel(application: Application) : BaseViewModel(application) {

    private val _mainWord = MutableLiveData<String>()
    val mainWord: LiveData<String> = _mainWord

    lateinit var words: MutableSet<String>

    fun init(letter: String) {
        words = TranslationUtils.getDictionary(letter)
        _mainWord.value = words.first()
    }

    fun loadNextWord(): Boolean {
        words.remove(_mainWord.value)
        if (words.isEmpty()) {
            return false
        }
        _mainWord.value = words.first()
        return true
    }

    fun onAnswerClicked(word: String, answer: String): Boolean =
        TranslationUtils.getCorrectAnswer(word) == answer
}