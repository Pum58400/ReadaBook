package buu.example.myapp.addbook

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.example.myapp.database.BookDatabaseDao


class AddbookViewModelFactory(
    private val dataSource: BookDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddbookViewModel::class.java)) {
            return AddbookViewModel(dataSource, application) as T
        } else {
            throw IllegalAccessException("unknow view model class")
        }
    }
}