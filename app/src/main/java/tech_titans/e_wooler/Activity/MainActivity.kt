@file:OptIn(ExperimentalFoundationApi::class)

package tech_titans.e_wooler.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import tech_titans.e_wooler.Presentation.Onboarding.Component.OnBoardingPage
import tech_titans.e_wooler.Presentation.Onboarding.pages
import tech_titans.e_wooler.ui.theme.EwoolerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EwoolerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OnBoardingPage(page = pages[0])
                }
            }
        }
    }
}

