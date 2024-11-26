package dev.vengateshm.compose.bookapp.book.data.network

import dev.vengateshm.compose.bookapp.book.data.dto.SearchResponseDto
import dev.vengateshm.compose.bookapp.core.data.safeCall
import dev.vengateshm.compose.bookapp.core.domain.DataError
import dev.vengateshm.compose.bookapp.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) : RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title,language,cover_i,author_key,author_name,cover_edition_key,first_published_year,ratings_average,ratings_count,number_of_pages_median,edition_count"
                )
            }
        }
    }
}