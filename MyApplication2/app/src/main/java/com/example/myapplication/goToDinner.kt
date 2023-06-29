package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.dto.medicine
import kotlinx.android.synthetic.main.dinner_medi.*
import kotlinx.android.synthetic.main.moring_medi.*
import java.util.ArrayList

class goToDinner  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dinner_medi)

        val item_list3 = ArrayList<medicine>()
//        item_list3.add(medicine("이건", "sss", "sss", "sss"))
//        item_list3.add(medicine("저녁", "aaa", "aaa", "aaa"))
//        item_list3.add(medicine("약", "bbb", "aaa", "aaa"))

//        val adp3 = MainAdapter(item_list3, LayoutInflater.from(this@goToDinner))
//        recyclerviewD.adapter = adp3
//        recyclerviewD.layoutManager = LinearLayoutManager(this@goToDinner)
    }
}