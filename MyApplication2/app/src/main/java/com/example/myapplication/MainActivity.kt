package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dto.medicine
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item_list = ArrayList<medicine>()
        item_list.add(medicine("sss", "sss", "sss", "sss"))
        item_list.add(medicine("aaa", "aaa", "aaa", "aaa"))
        item_list.add(medicine("bbb", "bbb", "aaa", "aaa"))

        val adp = MainAdapter(item_list, LayoutInflater.from(this@MainActivity))
        recyclerview.adapter = adp
        recyclerview.layoutManager =LinearLayoutManager(this@MainActivity)

    }
}