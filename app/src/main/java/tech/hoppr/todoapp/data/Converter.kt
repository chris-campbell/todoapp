package tech.hoppr.todoapp.data

import androidx.room.TypeConverter
import tech.hoppr.todoapp.data.models.Priority

class Converter {
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}