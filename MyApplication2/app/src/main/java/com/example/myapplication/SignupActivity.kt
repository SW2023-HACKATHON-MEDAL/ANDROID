package com.example.myapplication

import RetrofitAPI
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.myapplication.R
import com.example.myapplication.dto.SignupDTO

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //초기 설정 피보호자
        var role = "nonManager"

        val btn_signup = findViewById<Button>(R.id.btn_Signup)
        val check_setmanager = findViewById<CheckBox>(R.id.checkBox)
        val text_setmanager = findViewById<EditText>(R.id.text_setmanager)

        val v_loginid = findViewById<EditText>(R.id.text_id)
        val v_password = findViewById<EditText>(R.id.text_pw)
        val v_username = findViewById<EditText>(R.id.text_name)
        val v_phonenumber = findViewById<EditText>(R.id.text_phonenumber)

        check_setmanager.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                text_setmanager.isEnabled = true
                role = "manager"
            }
            else{
                text_setmanager.isEnabled = false
                role = "nonManager"
            }
        }

        btn_signup.setOnClickListener{
            val loginid = v_loginid.text.toString()
            val password = v_password.text.toString()
            val username = v_username.text.toString()
            val phonenumber = v_phonenumber.text.toString()
            var targetloginid: String? = text_setmanager.text.toString()

            if(!check_setmanager.isChecked){
                targetloginid = null
            }

            val retrofit = RetrofitClient.getInstance()
            val service = retrofit.create(RetrofitAPI::class.java)

            val signupDTO = SignupDTO(loginid, password, username, phonenumber, role, targetloginid)

            service.Signup(signupDTO)
                .enqueue(object: Callback<Boolean> {
                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                        Log.d("Failure", t.localizedMessage)
                    }

                    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        Log.d("Success", response.body().toString())
                        moveMain()
                    }
                })
        }
    }

    fun moveMain(){
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent);
    }

}