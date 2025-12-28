package dev.vengateshm.compose.bookapp.book.data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import dev.vengateshm.compose.bookapp.BookDatabase

class IosDatabaseDriverFactory: DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            BookDatabase.Schema,
            "BookDatabase.db"
        )
    }
}