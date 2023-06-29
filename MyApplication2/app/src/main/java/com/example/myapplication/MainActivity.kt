package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        morningBtn.setOnClickListener {
            val intent = Intent(this, goToMorning::class.java)
            startActivity(intent)
        }

        lunchBtn.setOnClickListener {
            val intent = Intent(this, goToLunch::class.java)
            startActivity(intent)
        }

        dinnerBtn.setOnClickListener {
            val intent = Intent(this, goToDinner::class.java)
            startActivity(intent)
        }
    }
}