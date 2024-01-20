package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object LoginScreen : Route(route = "loginScreen")
    object RegisterScreen : Route(route = "registerScreen")
    object HomeScreen : Route(route = "homeScreen")
    object AnalyticsScreen : Route(route = "analyticsScreen")
    object MapScreen : Route(route = "mapScreen")
    object CartScreen : Route(route = "cartScreen")
    object ProfileScreen : Route(route = "profileScreen")

    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")
}