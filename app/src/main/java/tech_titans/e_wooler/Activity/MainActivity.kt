package tech_titans.e_wooler.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import tech_titans.e_wooler.MainViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Nvgraph.Screens
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private  lateinit var navController: NavHostController
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()

        setContent {
            EwoolerTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = androidx.compose.ui.graphics.Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {


                }
            }
        }
    }
//    @Composable
//    private fun AuthState() {
//        val isUserSignedOut = viewModel.getAuthState().collectAsState().value
//        if (isUserSignedOut) {
//            NavigateToSignInScreen()
//        } else {
//                NavigateToHomeScreen()
//        }
//    }
    @Composable
    private fun NavigateToSignInScreen() = navController.navigate(Screens.LoginScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToRegisterScreen() = navController.navigate(Screens.RegisterScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToHomeScreen() = navController.navigate(Screens.HomeScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}

