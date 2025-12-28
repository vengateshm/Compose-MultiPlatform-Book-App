package dev.vengateshm.compose.bookapp.book.data.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dev.vengateshm.compose.bookapp.BookDatabase

class AndroidDatabaseDriverFactory(
    private val context: Context
): DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            BookDatabase.Schema,
            context,
            "BookDatabase.db"
        )
    }
}