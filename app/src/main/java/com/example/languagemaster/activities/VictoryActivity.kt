package com.example.languagemaster.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.languagemaster.R
import com.example.languagemaster.utils.TranslationUtils
import kotlinx.android.synthetic.main.activity_victory.*

class VictoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        val score = intent.getStringExtra(SCORE)!!
        txt_score.text = "${score}/10"
        when (score.toInt()) {
            in 1..3 -> {
                img_face.setImageDrawable(getDrawable(R.drawable.ic_face_sad))
            }
            in 4..6 -> {
                img_face.setImageDrawable(getDrawable(R.drawable.ic_face_calm))
            }
            in 7..10 -> {
                img_face.setImageDrawable(getDrawable(R.drawable.ic_face_happy))
            }
        }
    }

    companion object {
        const val SCORE = "SCORE"
    }
}