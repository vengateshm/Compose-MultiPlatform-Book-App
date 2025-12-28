package dev.vengateshm.compose.bookapp.book.data.mappers

import dev.vengateshm.compose.bookapp.BookTable
import dev.vengateshm.compose.bookapp.book.data.database.BookEntity
import dev.vengateshm.compose.bookapp.book.data.dto.SearchedBookDto
import dev.vengateshm.compose.bookapp.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = generateImageUrl(coverAlternativeKey, coverKey),
        authors = authorNames ?: emptyList(),
        description = null, // Assuming no description in SearchedBookDto
        languages = languages ?: emptyList(),
        firstPublishYear = firstPublishYear?.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions ?: 0
    )
}

// Helper function to generate the image URL
private fun generateImageUrl(coverAlternativeKey: Int?, coverKey: String?): String {
    return if (coverKey != null) {
        "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
    } else {
        "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
    }
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        ratingsAverage = averageRating,
        ratingsCount = ratingCount,
        numPagesMedian = numPages,
        numEditions = numEditions,
    )
}

fun BookEntity.toBook(): Book {
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishYear,
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions,
    )
}

fun BookTable.toBook(): Book {
    return Book(
        id = this.id,
        title = this.title,
        imageUrl = this.imageUrl,
        authors = emptyList(),
        description = this.description,
        languages = emptyList(),
        firstPublishYear = this.firstPublishYear,
        averageRating = this.ratingsAverage,
        ratingCount = this.ratingsCount?.toInt() ?: 0,
        numPages = this.numPagesMedian?.toInt() ?: 0,
        numEditions = this.numEditions.toInt()
    )
}