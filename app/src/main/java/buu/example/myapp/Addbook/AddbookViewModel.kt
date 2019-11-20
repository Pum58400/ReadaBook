package buu.example.myapp.Addbook

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import buu.example.myapp.database.Book
import buu.example.myapp.database.BookDatabaseDao
import kotlinx.coroutines.*

class AddbookViewModel(val database: BookDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    //    var inputBookId = MutableLiveData<String>()
    var inputNameBook = MutableLiveData<String>()
    var inputAnthor = MutableLiveData<String>()
    var inputPage = MutableLiveData<String>()


    private var _gotoShowbook = MutableLiveData<Boolean>()
    val gotoShowbook: LiveData<Boolean>
        get() = _gotoShowbook

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    init {
        Log.i("AddBookViewModel", "ViewModelCreate")
    }

    fun clickButton() {
        uiScope.launch {
            //            Log.i("AddBookViewModel","BookId :"+inputBookId.value)
            Log.i("AddBookViewModel", "BookName :" + inputNameBook.value)
            Log.i("AddBookViewModel", "Anthor :" + inputAnthor.value)
            Log.i("AddBookViewModel", "Page :" + inputPage.value)

            if (checkMatchNotNull()) {
                Log.i("AddBookViewModel", "get all " + showAll())
                _showSnackbarEvent.value = true
            } else {
                var newBook = Book(
                    bookname = inputNameBook.value,
                    anthor = inputAnthor.value,
                    page = inputPage.value
                )
                insert(newBook)
                Log.i("AddBookViewModel", "get  all " + showAll().toString())
                _gotoShowbook.value = true
            }
        }
    }

    private suspend fun showAll(): LiveData<List<Book>> {
        return withContext(Dispatchers.IO) {
            database.getAll()
        }
    }

    private suspend fun insert(book: Book) {
        withContext(Dispatchers.IO) {
            database.insert(book)
        }
    }

    private fun checkMatchNotNull() = (inputNameBook.value == null
            || inputAnthor.value == null
            || inputPage.value == null
            )

    override fun onCleared() {
        Log.i("RegisterViewModel", "ViewModelDestroy")
        super.onCleared()
        viewModelJob.cancel()
    }
}