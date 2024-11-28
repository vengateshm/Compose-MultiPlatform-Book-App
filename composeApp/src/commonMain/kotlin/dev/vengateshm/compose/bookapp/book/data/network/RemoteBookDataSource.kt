package dev.vengateshm.compose.bookapp.book.data.network

import dev.vengateshm.compose.bookapp.book.data.dto.BookWorkDto
import dev.vengateshm.compose.bookapp.book.data.dto.SearchResponseDto
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}