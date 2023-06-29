package com.example.myapplication

import RetrofitAPI
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.dto.LoginDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_movepage = findViewById<TextView>(R.id.btn_SignupPageOpen)

        btn_movepage.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent);
        }

        val v_id = findViewById<EditText>(R.id.text_id)
        val v_pw = findViewById<EditText>(R.id.text_pw)

        btn_login.setOnClickListener{
            val id = v_id.text.toString()
            val pw = v_pw.text.toString()
            val retrofit = RetrofitClient.getInstance()
            val service = retrofit.create(RetrofitAPI::class.java)

            val loginDTO = LoginDTO(id, pw)
            service.Login(loginDTO)
                .enqueue(object: Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        val res = response.body().toString()
                        Log.d("Success", res)
                        if(res == "manager" || res == "nonManager")
                            moveMain()
                        else{
                            //showAlert("아이디 또는 비밀번호가 다릅니다")
                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.d("Failure", t.localizedMessage)
                    }
                })
        }
    }

    fun showAlert(str: String){
        AlertDialog.Builder(applicationContext).apply {
            setTitle("알림창 제목")
            setMessage("메세지입니다. 메세지입니다. 메세지입니다. 메세지입니다.")
            setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "OK Button Click", Toast.LENGTH_SHORT).show()
            })
            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "Cancel Button Click", Toast.LENGTH_SHORT).show()
            })
            show()
        }
    }

    fun moveMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}