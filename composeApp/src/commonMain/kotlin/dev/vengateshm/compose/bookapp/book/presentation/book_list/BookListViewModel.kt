package dev.vengateshm.compose.bookapp.book.presentation.book_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vengateshm.compose.bookapp.book.domain.Book
import dev.vengateshm.compose.bookapp.book.domain.repository.BookRepository
import dev.vengateshm.compose.bookapp.book.presentation.BookListAction
import dev.vengateshm.compose.bookapp.core.domain.onError
import dev.vengateshm.compose.bookapp.core.domain.onSuccess
import dev.vengateshm.compose.bookapp.core.presentation.toUiText
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class BookListViewModel(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val _state = MutableStateFlow(BookListState())
    val state = _state
        .onStart {
            if (cachedBooks.isEmpty()) {
                observeSearchQuery()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private val cachedBooks = emptyList<Book>()
    private var _searchJob: Job? = null

    fun onAction(action: BookListAction) {
        when (action) {
            is BookListAction.OnBookClick -> {}
            is BookListAction.OnSearchQueryChanged -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }

            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }

    private fun observeSearchQuery() {
        state
            .map {
                it.searchQuery
            }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _state.update {
                            it.copy(
                                errorMessage = null,
                                searchResults = cachedBooks
                            )
                        }
                    }

                    query.length >= 2 -> {
                        _searchJob?.cancel()
                        _searchJob = searchBooks(query)
                    }
                }
            }.launchIn(viewModelScope)

    }

    private fun searchBooks(query: String) = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        bookRepository.searchBooks(query)
            .onSuccess { searchResults ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        searchResults = searchResults
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.toUiText(),
                        searchResults = emptyList()
                    )
                }
            }
    }
}