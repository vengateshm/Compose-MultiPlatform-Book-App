package dev.vengateshm.compose.bookapp.book.presentation.book_detail

import dev.vengateshm.compose.bookapp.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick : BookDetailAction
    data object OnFavoriteClick : BookDetailAction
    data class OnSelectedBookChange(val book: Book?) : BookDetailAction
}