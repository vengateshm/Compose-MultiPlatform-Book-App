package dev.vengateshm.compose.bookapp.book.domain.repository

import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(
        query: String,
    ): Result<List<Book>, DataError.Remote>

    suspend fun getBookDescription(
        bookId: String,
    ): Result<String?, DataError>
}