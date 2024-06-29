package muoipt.custompagerindicatorcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.PagerState

@Composable
fun CustomHorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = LocalContentColor.current.copy(alpha = 1f),
    inactiveColor: Color = activeColor.copy(0.5f),
    indicatorWidth: Dp = 8.dp,
    selectedIndicatorWidth: Dp = 16.dp,
    indicatorHeight: Dp = indicatorWidth,
    spacing: Dp = selectedIndicatorWidth,
    indicatorShape: Shape = CircleShape,
) {
    val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val indicatorModifier = Modifier
                .size(width = indicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            repeat(pagerState.pageCount) {
                Box(indicatorModifier)
            }
        }

        Box(
            Modifier
                .offset {
                    val scrollPosition = (pagerState.currentPage + pagerState.currentPageOffset)
                        .coerceIn(
                            0f,
                            (pagerState.pageCount - 1)
                                .coerceAtLeast(0)
                                .toFloat()
                        )
                    IntOffset(
                        x = (spacingPx * scrollPosition).toInt(),
                        y = 0
                    )
                }
                .size(width = selectedIndicatorWidth, height = indicatorHeight)
                .background(
                    color = activeColor,
                    shape = indicatorShape,
                )
        )
    }
}