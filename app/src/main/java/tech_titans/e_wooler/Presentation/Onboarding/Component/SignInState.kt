package tech_titans.e_wooler.Presentation.Onboarding.Component

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)