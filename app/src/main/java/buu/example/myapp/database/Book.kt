package buu.example.myapp.database



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class Book(
    @PrimaryKey(autoGenerate = true)
    var bookId: Int =0 ,

    @ColumnInfo(name = "bookname")
    var bookname : String?,

    @ColumnInfo(name = "anthor")
    var anthor : String?,

    @ColumnInfo(name = "page")
    var page : String?




)