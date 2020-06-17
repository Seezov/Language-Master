package com.example.languagemaster.utils

import kotlin.collections.HashSet

object TranslationUtils {

    private lateinit var dictionary: Map<String, String>

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
        "Through" to "Через",
        "Thought" to "Мысль",
        "Though" to "Хотя",
        "Taught" to "Учить",
        "Tough" to "Жесткий",
        "Tongue" to "Язык",
        "Trailer" to "Трейлер",
        "Thriller" to "Триллер",
        "Tinker" to "Чинить",
        "Thinker" to "Мыслитель"
    )

    private val dictionaryM = mapOf(
        "Market" to "Рынок",
        "Marker" to "Маркер",
        "Mature" to "Взрослый",
        "Midday" to "Полдень",
        "Mayday" to "SOS",
        "Might" to "Мощь",
        "Maven" to "Знаток",
        "Mind" to "Разум",
        "Maker" to "Создатель",
        "Misty" to "Туманный"
    )

    var fProgress = 0
    var tProgress = 0
    var mProgress = 0

    fun getAnswers(word: String): Array<String> {
        val correctAnswer = getCorrectAnswer(word)
        val answers = listOf(correctAnswer) + dictionary.values.filter { it != correctAnswer }.shuffled().take(3)
        return answers.shuffled().toTypedArray()
    }

    fun getCorrectAnswer(word: String) = dictionary[word] ?: error("")

    fun getDictionary(letter: String): MutableSet<String> {
        val selectedDictionary = when (letter) {
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
        dictionary = selectedDictionary
        return HashSet(selectedDictionary.keys).toMutableSet()
    }
}