package com.example.pam_2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HasilActivity : AppCompatActivity(){
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textViewResult = findViewById(R.id.textHasil)

        // Ambil hasil dari Intent
        val result = intent.getDoubleExtra("result", 0.0)
        textViewResult.text = "Hasil: $result"
    }
}

