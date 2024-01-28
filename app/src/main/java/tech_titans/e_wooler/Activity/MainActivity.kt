package tech_titans.e_wooler.Activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import tech_titans.e_wooler.Presentation.Onboarding.Nvgraph.NavigationGraph
import tech_titans.e_wooler.Util.Viewmodel.MainViewModel
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private lateinit var navController: NavHostController
    private val viewModel by viewModels<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        val sharedPreferences = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

        setContent {
            EwoolerTheme {

                NavigationGraph()

            }
        }
    }
}





