package tech.hoppr.todoapp.data.repository

import androidx.lifecycle.LiveData
import tech.hoppr.todoapp.data.ToDoDao
import tech.hoppr.todoapp.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }
}