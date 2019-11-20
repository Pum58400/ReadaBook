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

//    var inputBookId = MutableLiveData<Int>()
    var inputNameBook = MutableLiveData<String>()
    var inputAnthor = MutableLiveData<String>()
    var inputPage = MutableLiveData<String>()



    private var _gotoHome = MutableLiveData<Boolean>()
    val gotoHome: LiveData<Boolean>
        get() = _gotoHome

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    init {
        Log.i("AddbookViewModel", "ViewModelCreate")
    }

    fun clickButton() {
        uiScope.launch {
//            Log.i("AddbookViewModel", "IDBook :" + inputBookId.value)
            Log.i("AddbookViewModel", "NameBook :" + inputNameBook.value)
            Log.i("AddbookViewModel", "Anthor :" + inputAnthor.value)
            Log.i("AddbookViewModel", "Page :" + inputPage.value)
            if (checkMatchNotNull()) {
                Log.i("AddbookViewModel", "get gym all " + showGymAll())
                _showSnackbarEvent.value = true
            } else {
                var newBook = Book(
//                    bookId = inputBookId.value,
                    bookname = inputNameBook.value,
                    anthor = inputAnthor.value,
                    page = inputPage.value
                )
                insert(newBook)
                Log.i("AddbookViewModel", "get gym all " + showGymAll().toString())
                _gotoHome.value = true
            }
        }
    }

    private suspend fun showGymAll(): LiveData<List<Book>> {
        return withContext(Dispatchers.IO) {
            database.getAll()
        }
    }

    private suspend fun insert(gym: Book) {
        withContext(Dispatchers.IO) {
            database.insert(gym)
        }
    }

    private fun checkMatchNotNull() = (inputNameBook.value == null
            || inputAnthor.value == null
            || inputPage.value == null
            )

//    override fun onCleared() {
//        Log.i("RegisterViewModel", "ViewModelDestroy")
//        super.onCleared()
//        viewModelJob.cancel()
//    }
}