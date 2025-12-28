package dev.vengateshm.compose.bookapp.di

import dev.vengateshm.compose.bookapp.book.data.database.DatabaseDriverFactory
import dev.vengateshm.compose.bookapp.book.data.database.DatabaseFactory
import dev.vengateshm.compose.bookapp.book.data.database.IosDatabaseDriverFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Darwin.create() }
        single { DatabaseFactory() }
        single<DatabaseDriverFactory> { IosDatabaseDriverFactory() }
    }