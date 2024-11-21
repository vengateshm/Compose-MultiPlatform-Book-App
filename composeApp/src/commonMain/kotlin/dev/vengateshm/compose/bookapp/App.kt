package dev.vengateshm.compose.bookapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListScreenRoot
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel() },
        onBookClick = {

        }
    )
}