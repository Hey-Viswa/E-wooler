package tech_titans.e_wooler.Presentation.Onboarding.State

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "Login Succesfull",
    val isError: String? = "Can't Login"
)