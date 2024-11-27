package dev.vengateshm.compose.bookapp.book.presentation

import androidx.lifecycle.ViewModel
import dev.vengateshm.compose.bookapp.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedBookViewModel : ViewModel() {
    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?) {
        _selectedBook.value = book
    }
}