package tech_titans.e_wooler.Presentation.Onboarding.Nvgraph

sealed class Screens(
    val route: String
) {
    object OnBoardingScreen : Screens(route = "onBoardingScreen")
    object SignupAndLoginScreen : Screens(route = "signupAndLoginscreen")
    object LoginScreen : Screens(route = "loginScreen")
    object RegisterScreen : Screens(route = "registerScreen")
    object HomeScreen : Screens(route = "homeScreen")
    object VerifyEmailScreen : Screens(route = "verifyEmailScreen")
    object ForgotPasswordScreen : Screens(route = "forgotPasswordScreen")

}