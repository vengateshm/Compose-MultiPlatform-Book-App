package dev.vengateshm.compose.bookapp.book.presentation.book_list

import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.presentation.BookListAction

sealed interface BookListAction {
    data class OnSearchQueryChanged(val query: String) : BookListAction
    data class OnBookClick(val book: Book) : BookListAction
    data class OnTabSelected(val index: Int) : BookListAction
}