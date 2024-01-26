package tech_titans.e_wooler.Presentation.Onboarding.Component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import tech_titans.e_wooler.Presentation.Onboarding.Common.Dimens.IndicatorSize
import tech_titans.e_wooler.ui.theme.BlueGray
import tech_titans.e_wooler.ui.theme.EwoolerTheme

/**
 * Pager indicator
 * Adapted from [Pager in Compose](https://developer.android.com/jetpack/compose/layouts/pager#add-page)
 */

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
    unselectedColor: androidx.compose.ui.graphics.Color = BlueGray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )

        }
    }
}


@Preview
@Composable
fun PageIndicatorPreview() {
    EwoolerTheme {
        PageIndicator(pageSize = 3, selectedPage = 0)
    }
}
