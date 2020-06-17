package com.example.languagemaster.utils

import kotlin.collections.HashSet

object TranslationUtils {

    private val dictionaryF = mapOf(
        "Flower" to "Цветок",
        "Flour" to "Мука",
        "Floor" to "Пол",
        "Flood" to "Наводнение",
        "Flaw" to "Недостаток",
        "Flavor" to "Вкус",
        "Flash" to "Вспышка",
        "Flesh" to "Плоть",
        "Fresh" to "Свежий",
        "Fluid" to "Жидкость"
    )

    private val dictionaryT = mapOf(
        "Flower" to "Цветок",
        "Flour" to "Мука",
        "Floor" to "Пол",
        "Flood" to "Наводнение",
        "Flaw" to "Недостаток",
        "Flavor" to "Вкус",
        "Flash" to "Вспышка",
        "Flesh" to "Плоть",
        "Fresh" to "Свежий",
        "Fluid" to "Жидкость"
    )

    private val dictionaryM = mapOf(
        "Flower" to "Цветок",
        "Flour" to "Мука",
        "Floor" to "Пол",
        "Flood" to "Наводнение",
        "Flaw" to "Недостаток",
        "Flavor" to "Вкус",
        "Flash" to "Вспышка",
        "Flesh" to "Плоть",
        "Fresh" to "Свежий",
        "Fluid" to "Жидкость"
    )

    var fProgress = 0
    var tProgress = 0
    var mProgress = 0

    fun getAnswers(word: String): Array<String> {
        val correctAnswer = getCorrectAnswer(word)
        val answers = listOf(correctAnswer) + dictionaryF.values.filter { it != correctAnswer }.shuffled().take(3)
        return answers.shuffled().toTypedArray()
    }

    fun getCorrectAnswer(word: String) = dictionaryF[word] ?: error("")

    fun getDictionary(letter: String): MutableSet<String> {
        val dictionary = when (letter) {
            "F" -> {
                dictionaryF
            }
            "T" -> {
                dictionaryT
            }
            else -> {
                dictionaryM
            }
        }
        return HashSet(dictionary.keys).toMutableSet()
    }
}