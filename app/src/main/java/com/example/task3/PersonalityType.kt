package com.example.task3

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PersonalityType : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_personality_type)

        val spinnerType=findViewById<Spinner> (R.id.spinnerPersons)
        val textViewDescription=findViewById<TextView> (R.id.textViewFind)
        val button= findViewById<Button> (R.id.btnFindType)
        button.setOnClickListener {
            val position = spinnerType.selectedItemPosition
            val description: String = getDescriptionByPosition(position)
            textViewDescription.text = description
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    private fun getDescriptionByPosition(position: Int): String {
        val description = resources.getStringArray(R.array.description_types)
        return description[position];
    }
}

