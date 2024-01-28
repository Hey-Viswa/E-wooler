package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

import tech_titans.e_wooler.Activity.LoginScreen
import tech_titans.e_wooler.Activity.RegisterScreen
import SignupAndLoginScreenLayout
import android.preference.PreferenceManager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech_titans.e_wooler.Activity.OnBoardingScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.OnBoardingScreen.route
) {
    val context = LocalContext.current
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val isFirstRun = remember { sharedPreferences.getBoolean("isFirstRun", true) }

    NavHost(
        navController = navController,
        startDestination = if (isFirstRun) {
            Screens.OnBoardingScreen.route
        } else {
            Screens.SignupAndLoginScreen.route
        }
    ) {
        composable(route = Screens.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screens.SignupAndLoginScreen.route) {
            SignupAndLoginScreenLayout(navController = navController)
        }
        composable(route = Screens.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
    }
}

