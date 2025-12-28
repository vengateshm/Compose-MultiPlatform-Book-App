package dev.vengateshm.compose.bookapp.di

import dev.vengateshm.compose.bookapp.book.data.database.AndroidDatabaseDriverFactory
import dev.vengateshm.compose.bookapp.book.data.database.DatabaseDriverFactory
import dev.vengateshm.compose.bookapp.book.data.database.DatabaseFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        single { DatabaseFactory(androidApplication()) }
        single<DatabaseDriverFactory> { AndroidDatabaseDriverFactory(androidContext()) }
    }