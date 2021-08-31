package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd:MM:yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date{
    var time = this.time
time += when(units){
    TimeUnits.SECOND -> value* SECOND
    TimeUnits.MINUTE -> value* MINUTE
    TimeUnits.HOUR -> value* HOUR
    TimeUnits.DAY -> value* DAY
}
this.time = time
    return this
}
fun Date.humanizeDiff(date:Date = Date() /*it is current date*/ ) : String{
    this //this id receiver date (User.lastVisit.humanizeDiff)
    val lastVisitTime = this.time //this is time in milliseconds last visit
    val timeDiff = date.time - lastVisitTime//difference between now time and lastVisit time
    return when(timeDiff){
        in 0 * SECOND..1 * SECOND -> "только что" //0 .. 1000 milliseconds [0..1000] // equivalent of 0 <= timeDiff && timeDiff <= 1000
        in (1 * SECOND).inc()..45 * SECOND -> "несколько секунд назад" //1001 ..45 000 milliseconds [1001 .. 45000]
        // .inc() this is increment (+1);  example : 9.inc() == 10
        in (45 * SECOND).inc()..75 * SECOND -> "минуту назад"
        in (75 * SECOND).inc()..45 * MINUTE -> "${timeDiff/60000} минут назад"
        in (45 * MINUTE).inc()..75 * MINUTE -> "час назад"
        in (75 * MINUTE).inc()..22 * HOUR -> "${timeDiff/36000000} часов назад"
        in (22 * HOUR).inc()..26 * HOUR -> "день назад"
        in (26 * HOUR).inc()..360 * DAY -> "${timeDiff/86400000} дней назад"

        else -> "более года назад"
    }}

enum class TimeUnits{
    SECOND, MINUTE, HOUR, DAY
}