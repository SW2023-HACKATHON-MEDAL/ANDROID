package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.dto.medicine
import kotlinx.android.synthetic.main.lunch_medi.*
import kotlinx.android.synthetic.main.moring_medi.*
import java.util.ArrayList

class goToLunch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lunch_medi)

        val item_list2 = ArrayList<medicine>()
        item_list2.add(medicine("이건", "sss", "sss", "sss"))
        item_list2.add(medicine("점심", "aaa", "aaa", "aaa"))
        item_list2.add(medicine("약", "bbb", "aaa", "aaa"))

        val adp2 = MainAdapter(item_list2, LayoutInflater.from(this@goToLunch))
        recyclerviewL.adapter = adp2
        recyclerviewL.layoutManager = LinearLayoutManager(this@goToLunch)
    }
}