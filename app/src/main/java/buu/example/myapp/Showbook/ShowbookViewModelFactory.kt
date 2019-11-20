package buu.example.myapp.Showbook

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.example.myapp.database.BookDatabaseDao


class ShowbookViewModelFactory(
    private val dataSource: BookDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowbookViewModel::class.java)) {
            return ShowbookViewModel(dataSource, application) as T
        } else {
            throw IllegalAccessException("unknow view model class")
        }
    }
}