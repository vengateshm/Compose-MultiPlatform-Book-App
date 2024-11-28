package dev.vengateshm.compose.bookapp.book.presentation.book_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.vengateshm.compose.bookapp.core.presentation.LightBlue

enum class ChipSize {
    SMALL,
    REGULAR
}

@Composable
fun BookChip(
    modifier: Modifier = Modifier,
    chipSize: ChipSize = ChipSize.REGULAR,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .widthIn(
                when (chipSize) {
                    ChipSize.SMALL -> 50.dp
                    ChipSize.REGULAR -> 80.dp
                }
            )
            .clip(RoundedCornerShape(16.dp))
            .background(LightBlue)
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp
            )
    ) {
        content()
    }
}