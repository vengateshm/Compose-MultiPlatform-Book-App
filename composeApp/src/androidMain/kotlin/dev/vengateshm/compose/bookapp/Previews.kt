package dev.vengateshm.compose.bookapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListScreen
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListState
import dev.vengateshm.compose.bookapp.book.presentation.book_list.components.BookSearchBar

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookSearchBarPreview(modifier: Modifier = Modifier) {
    MaterialTheme {
        BookSearchBar(
            searchQuery = "Kotlin",
            onSearchQueryChanged = {},
            onImeSearch = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        description = "Description $it",
        imageUrl = "https://test.com",
        authors = listOf("John Gray"),
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.67854,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}

@Preview
@Composable
private fun BookListScreenPreview() {
    BookListScreen(
        state = BookListState(
            searchResults = books,
        ),
        onAction = {

        }
    )
}