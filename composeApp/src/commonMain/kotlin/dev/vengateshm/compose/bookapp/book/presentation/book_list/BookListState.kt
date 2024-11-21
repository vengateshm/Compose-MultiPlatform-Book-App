package dev.vengateshm.compose.bookapp.book.presentation.book_list

import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)