package tech_titans.e_wooler.Util.Data

data class LoginUiState(
    val email: String = "",
    val password: String = "",

    val emailError : Boolean = false,
    val passwordError : Boolean  = false
)
