package dev.vengateshm.compose.bookapp.book.data.repository

import androidx.sqlite.SQLiteException
import dev.vengateshm.compose.bookapp.BookDatabase
import dev.vengateshm.compose.bookapp.book.data.database.DatabaseDriverFactory
import dev.vengateshm.compose.bookapp.book.data.mappers.toBook
import dev.vengateshm.compose.bookapp.book.data.network.RemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.domain.repository.BookRepository
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result
import dev.vengateshm.compose.bookapp.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SqlDelightRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    driverFactory: DatabaseDriverFactory
) : BookRepository {
    private val database = BookDatabase(driverFactory.createDriver())
    private val query = database.bookDatabaseQueries

    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = getFavoriteBook(bookId)
        return if (localResult == null) {
            remoteBookDataSource.getBookDetails(bookId)
                .map { dto ->
                    dto.description
                }
        } else {
            Result.Success(localResult.description)
        }
    }

    fun getFavoriteBook(id: String) = query.getFavoriteBook(id).executeAsOneOrNull()?.toBook()

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return getFavoriteBooks()
            .map { books ->
                books.any { it.id == id }
            }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        val favoriteBooks = query.getFavoriteBooks().executeAsList().map { it.toBook() }
        return flowOf(favoriteBooks)
    }

    override suspend fun markAsFavorite(book: Book): Result<Unit, DataError.Local> {
        return try {
            query.transaction {
                query.insertBook(
                    id = book.id,
                    title = book.title,
                    description = book.description,
                    imageUrl = book.imageUrl,
                    languages = "",
                    authors = "",
                    firstPublishYear = book.firstPublishYear,
                    ratingsAverage = book.averageRating,
                    ratingsCount = book.ratingCount?.toLong(),
                    numPagesMedian = book.numPages?.toLong(),
                    numEditions = book.numEditions.toLong(),
                    dummy = "dummy"
                )
            }
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        query.transaction {
            query.deleteFavoriteBook(id)
        }
    }
}