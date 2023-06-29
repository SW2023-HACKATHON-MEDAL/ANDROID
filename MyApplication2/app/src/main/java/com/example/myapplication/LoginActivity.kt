package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_movepage = findViewById<Button>(R.id.btn_SignupPageOpen)

        btn_movepage.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent);
        }

        btn_login.setOnClickListener{
            val id = findViewById<EditText>(R.id.text_id)
            val pw = findViewById<EditText>(R.id.text_pw)


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}