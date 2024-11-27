package dev.vengateshm.compose.bookapp.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListScreenRoot
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(/*engine: HttpClientEngine*/) {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.BookGraph
        ) {
            navigation<Route.BookGraph>(
                startDestination = Route.BookList
            ) {
                composable<Route.BookList> {
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
                        onBookClick = { book ->
                            navController.navigate(Route.BookDetail(book.id))
                        }
                    )
                }
                composable<Route.BookDetail> { entry ->
                    val args = entry.toRoute<Route.BookDetail>()
                }
            }
        }
    }
}