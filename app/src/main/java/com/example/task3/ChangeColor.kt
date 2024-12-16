package com.example.task3

import android.graphics.Color
import android.graphics.Color.rgb
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChangeColor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_color)

        val spinnerColors = findViewById<Spinner>(R.id.spinnerColors)
        val spinnerTextColors = findViewById<Spinner>(R.id.spinnerTextColors)
        val button = findViewById<Button>(R.id.btnSetColors)



        button.setOnClickListener {
            val backgroundColorPosition = spinnerColors.selectedItemPosition
            val textColorPosition = spinnerTextColors.selectedItemPosition



            val backgroundColor = when (backgroundColorPosition) {
                0 -> rgb(255,95,95)
                1 -> rgb(148, 255, 95)
                else -> Color.MAGENTA
            }
            val textColor = when (textColorPosition) {
                0 -> Color.BLACK
                1 -> rgb(5, 0, 250)
                else -> Color.MAGENTA
            }


            button.setBackgroundColor(backgroundColor)
            button.setTextColor(textColor)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}