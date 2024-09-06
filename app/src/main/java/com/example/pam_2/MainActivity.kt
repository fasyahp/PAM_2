package com.example.pam_2

//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var inputTambah: RadioButton
    private lateinit var inputKurang: RadioButton
    private lateinit var inputKali: RadioButton
    private lateinit var inputBagi: RadioButton
    private lateinit var tmbHasil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        inputTambah = findViewById(R.id.inputTambah)
        inputKurang = findViewById(R.id.inputKurang)
        inputKali = findViewById(R.id.inputKali)
        inputBagi = findViewById(R.id.inputBagi)
        tmbHasil = findViewById(R.id.tmbHasil)

        tmbHasil.setOnClickListener {
            val num1 = input1.text.toString().toDouble()
            val num2 = input2.text.toString().toDouble()
            var result = 0.0

            // Cek status masing-masing RadioButton
            when {
                inputTambah.isChecked -> result = num1 + num2
                inputKurang.isChecked -> result = num1 - num2
                inputKali.isChecked -> result = num1 * num2
                inputBagi.isChecked -> result = num1 / num2
            }

            // Pindah ke halaman hasil
            val intent = Intent(this, HasilActivity::class.java).apply {
                putExtra("result", result)
            }
            startActivity(intent)
        }
        input1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && input1.text.toString() == "Input") {
                input1.setText("")
            }
        }

        input2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && input2.text.toString() == "Input") {
                input2.setText("")
            }
        }
        inputTambah.setOnClickListener {
            inputKurang.isChecked = false
            inputKali.isChecked = false
            inputBagi.isChecked = false
        }

        inputKurang.setOnClickListener {
            inputTambah.isChecked = false
            inputKali.isChecked = false
            inputBagi.isChecked = false
        }

        inputKali.setOnClickListener {
            inputTambah.isChecked = false
            inputKurang.isChecked = false
            inputBagi.isChecked = false
        }

        inputBagi.setOnClickListener {
            inputTambah.isChecked = false
            inputKurang.isChecked = false
            inputKali.isChecked = false
        }

    }
}