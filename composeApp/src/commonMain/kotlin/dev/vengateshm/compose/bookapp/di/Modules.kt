package dev.vengateshm.compose.bookapp.di

import dev.vengateshm.compose.bookapp.book.data.network.KtorRemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.data.network.RemoteBookDataSource
import dev.vengateshm.compose.bookapp.book.data.repository.DefaultRepository
import dev.vengateshm.compose.bookapp.book.domain.repository.BookRepository
import dev.vengateshm.compose.bookapp.book.presentation.book_list.BookListViewModel
import dev.vengateshm.compose.bookapp.book.presentation.book_detail.BookDetailViewModel
import dev.vengateshm.compose.bookapp.book.presentation.SelectedBookViewModel
import dev.vengateshm.compose.bookapp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultRepository).bind<BookRepository>()
    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}