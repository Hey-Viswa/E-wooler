package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

sealed class Screens(
    val route: String
) {
    object OnBoardingScreen : Screens(route = "onBoardingScreen")
    object LoginScreen : Screens(route = "loginScreen")
    object RegisterScreen : Screens(route = "registerScreen")
    object HomeScreen : Screens(route = "homeScreen")
    object AnalyticsScreen : Screens(route = "analyticsScreen")
    object MapScreen : Screens(route = "mapScreen")
    object CartScreen : Screens(route = "cartScreen")
    object ProfileScreen : Screens(route = "profileScreen")
    object ForgotPasswordScreen : Screens(route = "forgotPasswordScreen")

    object AppStartNavigation : Screens(route = "appStartNavigation")
    object NewsNavigation : Screens(route = "newsNavigation")
    object NewsNavigatorScreen : Screens(route = "newsNavigatorScreen")
}