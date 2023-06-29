package com.example.myapplication.receiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class MyAlarmReceiver: BroadcastReceiver() {
    val CHANNEL_ID = "Test"
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.extras?.get("code") == MainActivity.REQUEST_CODE) {
            var count = intent.getIntExtra("count", 0)
            Log.d("myLog", "$count")


            createNotificationChannel(context)

            val intent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent = PendingIntent.getActivity(context, 101, intent, 0)

            val contents = "Contents Contents Contents Contents Contents Contents Contents " +
                    "Contents Contents Contents Contents Contents Contents Contents "

            // Notification
//            var builder01 = NotificationCompat.Builder(context, CHANNEL_ID).apply {
//                setSmallIcon(R.mipmap.ic_launcher)
//                setContentTitle("Title 1")  // Set Title
//                setContentText(contents)   // Set Content
//                priority = NotificationCompat.PRIORITY_DEFAULT  // Set PRIORITY
//                setContentIntent(pendingIntent) // Notification Click Event
//                setAutoCancel(true) // Remove After Click Notification
//            }

//            with(NotificationManagerCompat.from(context)) {
//                notify(5, builder01.build())
//            }
            val bundle = Bundle()
            startActivity(context, intent, bundle)
        }
    }

    private fun createNotificationChannel(context: Context?) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification_Ch"
            val descriptionText = "Test Notification"
            val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = descriptionText
            }

            val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}