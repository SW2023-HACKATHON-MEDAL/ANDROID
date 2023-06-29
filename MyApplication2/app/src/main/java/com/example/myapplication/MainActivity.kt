package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.core.content.edit
import com.example.myapplication.receiver.MyAlarmReceiver
import kotlinx.android.synthetic.main.activity_main.*
import java.time.OffsetDateTime
import java.time.ZoneOffset

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 101
    }

    lateinit var setting: SharedPreferences

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

//        val morning = OffsetDateTime.of(2023, 6, 29, 9, 0, 0, 0,0)

        switch01.setOnCheckedChangeListener { _, isCheck ->
            setting.edit {
                putBoolean("alarm", isCheck)
            }
            if(isCheck) {
                alarmManager.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + 1000 * 10,
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