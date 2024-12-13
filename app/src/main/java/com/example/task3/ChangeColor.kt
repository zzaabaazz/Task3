package com.example.task3

import android.icu.text.Transliterator.Position
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
                0 -> Color.RED
                1 -> Color.BLUE
                2 -> Color.GREEN
                3 -> Color.YELLOW
                else -> Color.MAGENTA
            }

            val textColor = when (textColorPosition) {
                0 -> Color.WHITE
                1 -> Color.BLACK
                2 -> Color.GRAY
                else -> Color.BLACK
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
    //TODO: Get colors
    private fun getColorByPosition(position: Int): Int {
        val color = resources.getColor(R.array.bgColors)
        return color[position];
    }
}