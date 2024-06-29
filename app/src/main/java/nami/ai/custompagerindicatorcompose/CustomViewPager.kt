package nami.ai.custompagerindicatorcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import nami.ai.custompagerindicatorcompose.ui.theme.CustomPagerIndicatorComposeTheme

@Composable
fun CustomViewPager(
    modifier: Modifier,
    itemList: List<AnimalCardData>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val pagerState = rememberPagerState(0)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3 / 4f)
        ) {
            HorizontalPager(
                count = itemList.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) { page ->
                AnimalCardView(itemList[page])
            }
        }


        CustomHorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            activeColor = Color.Black,
            inactiveColor = Color.Black.copy(alpha = 0.3F),
        )
    }
}

@Composable
fun AnimalCardView(data: AnimalCardData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(data.img),
            contentDescription = "animal_img",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(350.dp)
                .padding(top = 50.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = data.text,
            style = Typography().headlineSmall.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreView() {
    CustomPagerIndicatorComposeTheme {
        AnimalCardView(
            AnimalCardData(
                R.drawable.cute_cat,
                stringResource(id = R.string.cute_cat)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomViewPagerPreview() {
    CustomPagerIndicatorComposeTheme {
        CustomViewPager(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 50.dp),
            itemList = listOf(
                AnimalCardData(
                    R.drawable.cute_cat,
                    stringResource(id = R.string.cute_cat)
                ),
                AnimalCardData(
                    R.drawable.cute_dog,
                    stringResource(id = R.string.cute_dog)
                ),
            )
        )
    }
}