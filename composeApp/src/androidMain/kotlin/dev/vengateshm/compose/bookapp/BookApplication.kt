package dev.vengateshm.compose.bookapp

import android.app.Application
import dev.vengateshm.compose.bookapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@BookApplication)
        }
    }
}