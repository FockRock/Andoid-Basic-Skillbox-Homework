package com.skillbox.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this)
            .load("https://248006.selcdn.ru/main/iblock/def/def82b733a444368cf333916fe4066bd/bb84628188b5382ecf36329e7410e5cc.png")
            .into(image)

        passwordInput.addTextChangedListener(textWatcher)
        emailInput.addTextChangedListener(textWatcher)
        license.setOnCheckedChangeListener { buttonView, isChecked ->
            loginButton.isEnabled = checking()
        }

        loginButton.setOnClickListener {                                                            //После нажатия на кнопку создается прогресс-бар
            val progressBar = ProgressBar(this).apply {
                LinearLayout.LayoutParams(
                    50, 50
                ).apply { gravity = Gravity.CENTER }
                progressStart()
            }
            container.addView(progressBar)
            progressStop(progressBar)
        }
    }

    private val textWatcher = object : TextWatcher {                                                //Нужен для проверки заполненности текста
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            loginButton.isEnabled = checking()
        }

    }

    private fun progressStart() {                                                                   //Блокирует все кнопки на момент работы прогресс-бара
        loginButton.isEnabled = false
        emailInput.isEnabled = false
        passwordInput.isEnabled = false
        license.isEnabled = false
    }

    private fun progressStop(i: View) {                                                             //Удаляет прогресс-бар и включает кнопки
        Handler().postDelayed({
            container.removeView(i)
            loginButton.isEnabled = true
            emailInput.isEnabled = true
            passwordInput.isEnabled = true
            license.isEnabled = true
            Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
        }, 2000)
    }

    private fun checking(): Boolean {                                                               //Метод проверки
        return emailInput.text.toString().isNotEmpty() &&
                passwordInput.text.toString().isNotEmpty() && license.isChecked
    }
}