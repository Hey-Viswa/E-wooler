package tech_titans.e_wooler.Presentation.Onboarding.State

data class RegisterState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "Register Succesfull",
    val isError: String? = "Can't Register"

)