package com.egasmith.em.kotlin.delegate

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.reflect.KProperty

class GetTime() {
    val time: String by LaunchingAppTime()
}

class LaunchingAppTime {
    private val appStartTime = Date()
    private var runningTime: String = appStartTime.calculateRunningTime()
    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            while (isActive) {
                delay(3000)
                runningTime = appStartTime.calculateRunningTime()
                Log.d("NewAppRunningTime", runningTime)
            }
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return runningTime
    }
}

fun Date.calculateRunningTime(): String {
    val dateFormat = SimpleDateFormat("d MMMM в HH:mm", Locale("ru"))
    val formattedDate = dateFormat.format(this)

    val currentTime = Date()
    val differenceInMillis = currentTime.time - this.time
    val minutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMillis)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(differenceInMillis) % 60

    return "Приложение было запущено $formattedDate \n Приложение работает уже $minutes минут и $seconds секунд"
}
