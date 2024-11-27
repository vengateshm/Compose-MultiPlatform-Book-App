package dev.vengateshm.compose.bookapp

import androidx.compose.runtime.Composable
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListScreenRoot
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(/*engine: HttpClientEngine*/) {
    val viewModel = koinViewModel<BookListViewModel>()
    BookListScreenRoot(
        viewModel = /*remember { BookListViewModel(
            bookRepository = DefaultRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(
                        engine = engine
                    )
                )
            )
        ) }*/
        viewModel,
        onBookClick = {

        }
    )
}