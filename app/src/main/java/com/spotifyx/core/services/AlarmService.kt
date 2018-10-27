package com.spotifyx.core.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import java.util.*
import javax.inject.Inject


class AlarmService @Inject constructor
    (val context: Context) {

    fun setRepeatingAlarm(
        frequencySeconds: Int,
        receiver: Class<*>, requestCode: Int
    ) {
        val myIntent = Intent(context, receiver)
        val pendingIntent = PendingIntent.getBroadcast(context, requestCode, myIntent, 0)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.SECOND, frequencySeconds) // first time
        val frequency = (60 * 1000).toLong() // in ms
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), frequency, pendingIntent)
    }

}