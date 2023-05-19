package com.kay.todopublish.data.repository

import com.kay.todopublish.data.ToDoDao
import com.kay.todopublish.data.models.TaskData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    /**
     * Just a general naming comment, but if you are returning or deleting a list of things, it is
     * a good idea to name the variable plural. So instead of getAllTask, it would be getAllTasks.
     * This is something I noticed in a few places in the app but I will only comment on it here.
     */
    // access all functions from Dao
    val getAllTask: Flow<List<TaskData>> = toDoDao.getAllTask()
    val sortByLowPriority: Flow<List<TaskData>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TaskData>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TaskData> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(taskData: TaskData) {
        toDoDao.addTask(taskData = taskData)
    }

    suspend fun updateTask(taskData: TaskData) {
        toDoDao.updateTask(taskData = taskData)
    }

    suspend fun deleteTask(taskData: TaskData) {
        toDoDao.deleteTask(taskData = taskData)
    }

    suspend fun deleteAllTask() {
        toDoDao.deleteAllTask()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TaskData>> {
        return toDoDao.searchDataBase(searchQuery = searchQuery)
    }
}
