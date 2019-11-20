package buu.example.myapp.showbook

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import buu.example.myapp.database.BookDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ShowbookViewModel(val database: BookDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val book = database.getAll()

    init {
        Log.i("ShowbookViewModel", "ViewModelCreate")
    }

    override fun onCleared() {
        Log.i("ShowbookViewModel", "ViewModelDestroy")
        super.onCleared()
    }
}