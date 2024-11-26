package dev.vengateshm.compose.bookapp.book.data.mappers

import dev.vengateshm.compose.bookapp.book.data.dto.SearchedBookDto
import dev.vengateshm.compose.bookapp.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id,
        title = title,
        imageUrl = generateImageUrl(coverAlternativeKey, coverKey),
        authors = authorNames ?: emptyList(),
        description = null, // Assuming no description in SearchedBookDto
        languages = languages ?: emptyList(),
        firstPublishedYear = firstPublishYear?.toString(),
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