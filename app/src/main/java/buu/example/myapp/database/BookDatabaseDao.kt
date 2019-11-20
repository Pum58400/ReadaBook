package buu.example.myapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface BookDatabaseDao {
    @Insert
    fun insert(user: Book)


    @Query("SELECT * FROM  book WHERE bookId = :bookId")
    fun getBook(bookId:Int) : Book?

    @Query("SELECT * FROM book")
    fun getAll(): LiveData<List<Book>>
}