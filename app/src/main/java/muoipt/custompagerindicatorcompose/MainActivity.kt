package muoipt.custompagerindicatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import muoipt.custompagerindicatorcompose.ui.theme.CustomPagerIndicatorComposeTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomPagerIndicatorComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    CustomViewPager(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomPagerIndicatorComposeTheme {
        Greeting()
    }
}