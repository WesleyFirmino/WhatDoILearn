package com.devventurus.whatdoilearn.data

import androidx.room.TypeConverter
import com.devventurus.whatdoilearn.R

class Converters {

    @TypeConverter
    fun levelToInt(level: UnderstandingLevel) : Int {
        return level.ordinal
    }

    @TypeConverter
    fun intToLevel(color: Int) : UnderstandingLevel {

        return when (color) {
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}