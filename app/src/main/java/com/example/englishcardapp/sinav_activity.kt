package com.example.englishcardapp

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_sinav.*

class sinav_activity : AppCompatActivity() {

    var sayi: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinav)

        val turkishWords = ArrayList<String>()
        turkishWords.add("HELLO")
        turkishWords.add("pencil")

        val englishWords = ArrayList<String>()
        englishWords.add("MERHABA")
        englishWords.add("KALEM")

        txtenglish.text = turkishWords.get(0)

        btnSonraki.setOnClickListener {

            if (englishWords.size - 1 == sayi) {
                Toast.makeText(applicationContext, "Sona geldiniz", Toast.LENGTH_LONG).show()
            } else {
                sayi++
            }

            txtenglish.text = turkishWords.get(sayi).toString()
            etxtgir.setText("")

        }

        btnOnce.setOnClickListener {
            if (0 == sayi) {
                Toast.makeText(applicationContext, "Başa geldiniz", Toast.LENGTH_LONG).show()
            } else {
                sayi--
            }
            txtenglish.text = turkishWords.get(sayi).toString()
            etxtgir.setText("")
        }

        btnkontrol.setOnClickListener {
            if (etxtgir.text.toString().toUpperCase() == englishWords.get(sayi)) {
                constraint11.setBackgroundColor(Color.GREEN)
            } else {
                constraint11.setBackgroundColor(Color.RED)
            }
            closeKeyboard(etxtgir)
        }
    }

    private fun closeKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}