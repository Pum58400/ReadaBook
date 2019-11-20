package buu.example.myapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Book::class],version = 1,exportSchema = false)

abstract class Roomdb : RoomDatabase(){


    abstract val bookDao: BookDatabaseDao
    

    companion object {
        @Volatile
        private var INSTANCE: Roomdb? = null

        fun getInstance(context: Context): Roomdb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Roomdb::class.java,
                        "DB_Start"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}