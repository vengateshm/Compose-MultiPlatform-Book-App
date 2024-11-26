package dev.vengateshm.compose.bookapp.core.presentation

import bookapp.composeapp.generated.resources.Res
import bookapp.composeapp.generated.resources.error_disk_full
import bookapp.composeapp.generated.resources.error_no_internet
import bookapp.composeapp.generated.resources.error_request_timeout
import bookapp.composeapp.generated.resources.error_serialization
import bookapp.composeapp.generated.resources.error_too_many_requests
import bookapp.composeapp.generated.resources.error_unknown
import dev.vengateshm.compose.bookapp.core.domain.DataError

fun DataError.toUiText(): UiText {
    return when (this) {
        DataError.Local.DISK_FULL -> UiText.StringResourceId(Res.string.error_disk_full)
        DataError.Local.UNKNOWN -> UiText.StringResourceId(Res.string.error_unknown)
        DataError.Remote.REQUEST_TIMEOUT -> UiText.StringResourceId(Res.string.error_request_timeout)
        DataError.Remote.TOO_MANY_REQUESTS -> UiText.StringResourceId(Res.string.error_too_many_requests)
        DataError.Remote.NO_INTERNET -> UiText.StringResourceId(Res.string.error_no_internet)
        DataError.Remote.SERVER -> UiText.StringResourceId(Res.string.error_unknown)
        DataError.Remote.SERIALIZATION -> UiText.StringResourceId(Res.string.error_serialization)
        DataError.Remote.UNKNOWN -> UiText.StringResourceId(Res.string.error_unknown)
    }
}