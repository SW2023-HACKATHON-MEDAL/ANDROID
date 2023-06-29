package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.dto.medicine
import kotlinx.android.synthetic.main.moring_medi.*
import java.util.ArrayList

class goToMorning : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.moring_medi)

        val item_list1 = ArrayList<medicine>()
        item_list1.add(medicine("이건", "sss", "sss", "sss"))
        item_list1.add(medicine("아침", "aaa", "aaa", "aaa"))
        item_list1.add(medicine("약", "bbb", "aaa", "aaa"))

        val adp = MainAdapter(item_list1, LayoutInflater.from(this@goToMorning))
        recyclerview.adapter = adp
        recyclerview.layoutManager = LinearLayoutManager(this@goToMorning)
    }
}