package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

import LoginScreen
import RegisterScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech_titans.e_wooler.Activity.OnBoardingScreen
import tech_titans.e_wooler.Activity.SignupAndLoginScreenLayout

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.OnBoardingScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
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

//private fun determineStartDestination(navController: NavHostController): String {
//    val isLoggedIn = SharedPreferencesHelper.isLoggedIn(navController.context)
//    return if (!isLoggedIn) {
//        Screens.OnBoardingScreen.route // Or your main screen route
//    } else {
//        Screens.SignupAndLoginScreen.route
//    }
//}