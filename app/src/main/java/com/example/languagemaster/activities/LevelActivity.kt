package com.example.languagemaster.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.languagemaster.R
import com.example.languagemaster.activities.MainActivity.Companion.MAIN_LETTER
import com.example.languagemaster.utils.TranslationUtils
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        layout_f.setOnClickListener {
            launchGame("F")
        }
        layout_t.setOnClickListener {
            launchGame("T")
        }
        layout_m.setOnClickListener {
            launchGame("M")
        }
    }

    override fun onResume() {
        super.onResume()
        txt_score_f.text = "${TranslationUtils.fProgress}/10"
        txt_score_t.text = "${TranslationUtils.tProgress}/10"
        txt_score_m.text = "${TranslationUtils.mProgress}/10"
    }

    private fun launchGame(letter: String) {
        startActivity(Intent(this, MainActivity::class.java).apply {
            putExtra(MAIN_LETTER, letter)
        })
    }
}