package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHost
import tech_titans.e_wooler.Activity.Registerscreen
import tech_titans.e_wooler.Presentation.Onboarding.OnBoardingScreen
import tech_titans.e_wooler.Presentation.Onboarding.OnBoardingViewModel

//@Composable
//fun NavGraph(
//    startDestination: String
//) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = startDestination) {
//        navigation(
//            route = Screens.AppStartNavigation.route,
//            startDestination = Screens.OnBoardingScreen.route
//        ) {
//            composable(
//                route = Screens.OnBoardingScreen.route
//            ) {
//                val viewModel: OnBoardingViewModel = hiltViewModel()
//                OnBoardingScreen(
//                    event = viewModel::onEvent
//                )
//            }
//        }
//        navigation(
//            route = Screens.NewsNavigation.route,
//            startDestination = Screens.NewsNavigatorScreen.route
//        ) {
//            composable(
//                route = Screens.NewsNavigatorScreen.route
//            ) {
//                Registerscreen()
//            }
//        }
//    }
//}