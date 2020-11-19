package tech.hoppr.todoapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.hoppr.todoapp.data.ToDoDatabase
import tech.hoppr.todoapp.data.models.ToDoData
import tech.hoppr.todoapp.data.repository.ToDoRepository

class ToDoViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository

    private val getAllData: LiveData<List<ToDoData>>


    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }

    fun insertData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)
        }
    }
}