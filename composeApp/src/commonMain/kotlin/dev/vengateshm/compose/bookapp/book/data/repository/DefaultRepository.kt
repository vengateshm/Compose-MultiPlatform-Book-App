package dev.vengateshm.compose.bookapp.book.data.repository

import androidx.sqlite.SQLiteException
import dev.vengateshm.compose.bookapp.book.data.database.FavoriteBookDao
import dev.vengateshm.compose.bookapp.book.data.mappers.toBook
import dev.vengateshm.compose.bookapp.book.data.mappers.toBookEntity
import dev.vengateshm.compose.bookapp.book.data.network.RemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.domain.repository.BookRepository
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result
import dev.vengateshm.compose.bookapp.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(
        query: String,
    ): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource.searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)
        return if (localResult == null) {
            remoteBookDataSource.getBookDetails(bookId)
                .map { dto ->
                    dto.description
                }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao.getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): Result<Unit, DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}