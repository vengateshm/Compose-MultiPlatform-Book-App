package dev.vengateshm.compose.bookapp.book.domain.repository

import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(
        query: String,
    ): Result<List<Book>, DataError.Remote>

    suspend fun getBookDescription(
        bookId: String,
    ): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): Result<Unit, DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}