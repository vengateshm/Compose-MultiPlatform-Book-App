package dev.vengateshm.compose.bookapp.book.presentation.book_detail

import dev.vengateshm.compose.bookapp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
