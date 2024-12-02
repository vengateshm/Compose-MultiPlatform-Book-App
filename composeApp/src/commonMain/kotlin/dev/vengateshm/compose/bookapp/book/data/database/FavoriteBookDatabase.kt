package dev.vengateshm.compose.bookapp.book.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BookEntity::class], version = 1)
@TypeConverters(StringListTypeConverter::class)
abstract class FavoriteBookDatabase : RoomDatabase() {
    abstract val favoriteBookDao: FavoriteBookDao

    companion object {
        val DB_NAME = "book.db"
    }
}