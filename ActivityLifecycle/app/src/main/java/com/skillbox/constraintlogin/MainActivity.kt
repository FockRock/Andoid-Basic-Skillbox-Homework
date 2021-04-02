package com.skillbox.constraintlogin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "Main Activity"
    var text: ErrorState = ErrorState("")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            text = savedInstanceState.getParcelable(KEY_COUNTER) ?: error("Unexpected state!")
            errorText.text = text.error
        }

        Log.d(tag, "onCreate")

        Glide.with(this)
                .load("https://248006.selcdn.ru/main/iblock/def/def82b733a444368cf333916fe4066bd/bb84628188b5382ecf36329e7410e5cc.png")
                .into(logo)

        group.referencedIds.forEach {
            findViewById<View>(it).setOnClickListener {
                Toast.makeText(this, "Enter it!", Toast.LENGTH_SHORT).show()
            }
        }

        anr.setOnClickListener {
            Thread.sleep(15000)
        }


        loginButton.setOnClickListener {
            loginButton.isEnabled = false
            emailInput.isEnabled = false
            passwordInput.isEnabled = false
            license.isEnabled = false
            Toast.makeText(this, "Information checking...", Toast.LENGTH_SHORT).show()

            if (checking()) {
                Handler().postDelayed({
                    loginButton.isEnabled = true
                    emailInput.isEnabled = true
                    passwordInput.isEnabled = true
                    license.isEnabled = true
                    Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                }, 2000)
            } else {
                Handler().postDelayed({
                    loginButton.isEnabled = true
                    emailInput.isEnabled = true
                    passwordInput.isEnabled = true
                    license.isEnabled = true
                    errorText.text = "Validate incomplete!"
                    text.changeText(errorText.text.toString())
                }, 2000)
            }
        }
    }

    private fun checking(): Boolean {
        return emailInput.text.toString().isNotEmpty()
                && passwordInput.text.toString().isNotEmpty()
                && license.isChecked
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_COUNTER, text)
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val KEY_COUNTER = "counter"
    }
}