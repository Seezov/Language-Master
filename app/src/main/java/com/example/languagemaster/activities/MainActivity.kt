package com.example.languagemaster.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.Observer
import com.example.languagemaster.R
import com.example.languagemaster.utils.TranslationUtils
import com.example.languagemaster.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    var isClickable = true

    private val answerButtons by lazy {
        arrayOf(btn_first_answer, btn_second_answer, btn_third_answer, btn_fourth_answer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.init(intent.getStringExtra(MAIN_LETTER))

        progress.progress = 0
        viewModel.mainWord.observe(this, Observer { word ->
            txt_word.text = word

            val answers = TranslationUtils.getAnswers(word!!)
            answerButtons.forEachIndexed { index, button ->
                val answer = answers[index]
                button.text = answer
                button.background = getDrawable(R.drawable.bg_answers)
                button.setTextColor(getColor(R.color.black))
                button.setOnClickListener {
                    if (isClickable) {
                        isClickable = false
                        val isCorrect = viewModel.onAnswerClicked(word, answer)
                        button.background = getDrawable(
                            if (isCorrect) {
                                R.drawable.bg_correct_answer
                            } else {
                                R.drawable.bg_wrong_answer
                            }
                        )
                        button.setTextColor(
                            getColor(
                                if (isCorrect) {
                                    R.color.black
                                } else {
                                    R.color.white
                                }
                            )
                        )
                        Toast.makeText(
                            this,
                            if (isCorrect) {
                                "Correct!"
                            } else {
                                "Wrong!"
                            }
                            , LENGTH_SHORT
                        ).show()
                        Handler().postDelayed({
                            if(viewModel.loadNextWord()) {
                                progress.progress++
                            }
                            isClickable = true
                        }, 1000)
                    }
                }
            }
        })
    }

    companion object {
        const val MAIN_LETTER = "MAIN_LETTER"
    }
}
