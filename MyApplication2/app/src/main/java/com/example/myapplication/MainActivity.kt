package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.edit
import com.example.myapplication.receiver.MyAlarmReceiver
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 101
    }

    lateinit var setting: SharedPreferences

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setting = getSharedPreferences("setting", MODE_PRIVATE)
        switch01.isChecked = setting.getBoolean("alarm", false)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val pendingIntent = Intent(this, MyAlarmReceiver::class.java).let {
            it.putExtra("code", REQUEST_CODE)
            it.putExtra("count", 10)
            PendingIntent.getBroadcast(this, REQUEST_CODE, it, 0)
        }


        switch01.setOnCheckedChangeListener { _, isCheck ->
            setting.edit {
                putBoolean("alarm", isCheck)
            }
            if(isCheck) {
                var mtime=intent.getStringExtra("mt")
                var charseq = "2023-06-30 "+mtime+":00"
                var starttime = "1970-01-01 00:00:00"
                var today = Calendar.getInstance()
                var sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                var sett = sf.parse(charseq)
                var calcuDate = (sett.time - today.time.time)
                Log.d("값1:",calcuDate.toString())
                Log.d("값2:",SystemClock.elapsedRealtime().toString())
                alarmManager.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                   SystemClock.elapsedRealtime() + 1000 * 10,
                    calcuDate + 1000 * 10,
                    pendingIntent
                )
            } else {
                alarmManager.cancel(pendingIntent)
            }
        }

        morningBtn.setOnClickListener{
            val intent = Intent(this, goToMorning::class.java)
            startActivity(intent);
        }
        LunchBtn.setOnClickListener{
            val intent = Intent(this, goToLunch::class.java)
            startActivity(intent);
        }
        DinnerBtn.setOnClickListener{
            val intent = Intent(this, goToDinner::class.java)
            startActivity(intent);
        }
    }
}