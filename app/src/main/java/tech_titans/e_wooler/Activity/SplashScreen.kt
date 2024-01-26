package tech_titans.e_wooler.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import tech_titans.e_wooler.R
import tech_titans.e_wooler.ui.theme.EwoolerTheme
import tech_titans.e_wooler.ui.theme.Mushroom_white

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EwoolerTheme {
                splashScreen()
            }
        }
    }

    @Preview
    @SuppressLint("ComposableNaming")
    @Composable
    private fun splashScreen() {
        LaunchedEffect(key1 = true) {
            delay(2000)
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Mushroom_white)
                .padding(start = 20.dp),
            contentAlignment = Alignment.Center,

            ) {
            Image(
                painter = painterResource(id = R.drawable.ewooler),
                contentDescription = null
            )
        }
    }
}