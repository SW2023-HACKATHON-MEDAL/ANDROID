package com.example.myapplication

import RetrofitAPI
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.dto.TypeDTO
import com.example.myapplication.dto.medicine
import kotlinx.android.synthetic.main.moring_medi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class goToMorning : AppCompatActivity()  {
    companion object {
        const val REQUEST_CODE = 101
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moring_medi)
        var morningCheck :Int
        val item_list1 = ArrayList<medicine>()
        val retrofit = RetrofitClient.getInstance()
        val service = retrofit.create(RetrofitAPI::class.java)
        val m=0
        val typeDTO : TypeDTO = TypeDTO(m)
        service.InfoAlarm(typeDTO).enqueue(object: Callback<List<medicine>>{
            override fun onResponse(call: Call<List<medicine>>, response: Response<List<medicine>>) {
                val res = response.body()
                Log.d("log : ", res.isNullOrEmpty().toString())
                if(!res.isNullOrEmpty())
                    res.forEach{
                        item_list1.add(it)
                    }
                else{
                    //showAlert("아이디 또는 비밀번호가 다릅니다")
                }
            }

            override fun onFailure(call: Call<List<medicine>>, t: Throwable) {
                Log.d("Failure", t.localizedMessage)
            }
        })

        val adp = MainAdapter(item_list1, LayoutInflater.from(this@goToMorning), this@goToMorning)
        recyclerview.adapter = adp
        recyclerview.layoutManager = LinearLayoutManager(this@goToMorning)

        morningCheckingBtn.setOnClickListener {
            morningCheck = 0
            val retrofit = RetrofitClient.getInstance()
            val service = retrofit.create(RetrofitAPI::class.java)
            service.TakePill(TypeDTO(morningCheck))
                .enqueue(object: Callback<Boolean>{
                    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                        val res = response.body().toString()
                        Log.d("Success", res)
                        if(res == "manager" || res == "nonManager")
                            moveMain()
                        else{
                            //showAlert("아이디 또는 비밀번호가 다릅니다")
                        }
                    }

                    override fun onFailure(call: Call<Boolean>, t: Throwable) {
                        Log.d("Failure", t.localizedMessage)
                    }
                })
        }
    }
    fun moveMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}