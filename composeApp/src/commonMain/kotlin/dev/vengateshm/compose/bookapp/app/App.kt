package dev.vengateshm.compose.bookapp.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.vengateshm.compose.bookapp.book.presentation.SelectedBookViewModel
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
                composable<Route.BookList> { navBackStackEntry ->
                    val viewModel = koinViewModel<BookListViewModel>()
                    val selectedBookViewModel =
                        navBackStackEntry.sharedKoinViewModel<SelectedBookViewModel>(navController)

                    LaunchedEffect(true) {
                        selectedBookViewModel.onSelectBook(null)
                    }

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
                            selectedBookViewModel.onSelectBook(book)
                            navController.navigate(Route.BookDetail(book.id))
                        }
                    )
                }
                composable<Route.BookDetail> { navBackStackEntry ->
                    val args = navBackStackEntry.toRoute<Route.BookDetail>()
                    val selectedBookViewModel =
                        navBackStackEntry.sharedKoinViewModel<SelectedBookViewModel>(navController)
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedKoinViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}