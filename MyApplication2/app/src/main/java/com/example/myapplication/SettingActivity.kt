package com.example.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.setting_time.*
import java.text.SimpleDateFormat
import java.util.*

class SettingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_time)
        var timeString: String=""
        var intent = Intent(this, MainActivity::class.java)
        morningTimeInput.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}:${minute}"
                morningTime.text = timeString
                intent.putExtra("mt",timeString)
            }
            TimePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()
        }

        lunchTimeInput.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}:${minute}"
                lunchTime.text = timeString
//                intent.putExtra("lt",timeString)
            }
            TimePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()

        }

        dinnerTimeInput.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay}:${minute}"
                dinnerTime.text = timeString
//                intent.putExtra("dt",timeString)
            }
            TimePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_NoActionBar, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()

        }

        gotoMainBtn.setOnClickListener {
            startActivity(intent);
        }
    }
}