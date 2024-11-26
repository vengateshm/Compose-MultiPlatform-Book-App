package dev.vengateshm.compose.bookapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.vengateshm.compose.bookapp.book.data.network.KtorRemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.data.repository.DefaultRepository
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListScreenRoot
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListViewModel
import dev.vengateshm.compose.bookapp.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            bookRepository = DefaultRepository(
                remoteBookDataSource = KtorRemoteBookDataSource(
                    httpClient = HttpClientFactory.create(
                        engine = engine
                    )
                )
            )
        ) },
        onBookClick = {

        }
    )
}