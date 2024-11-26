package dev.vengateshm.compose.bookapp.book.data.repository

import dev.vengateshm.compose.bookapp.book.data.mappers.toBook
import dev.vengateshm.compose.bookapp.book.data.network.RemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.domain.repository.BookRepository
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result
import dev.vengateshm.compose.bookapp.core.domain.map

class DefaultRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(
        query: String,
    ): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}