package tech_titans.e_wooler.Util.Viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import tech_titans.e_wooler.Util.Data.LoginUiState
import tech_titans.e_wooler.Util.Data.UiEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {
    private val Tag = LoginViewModel::class.simpleName
    var loginUiState = mutableStateOf(LoginUiState())

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.EmailChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    email = event.email
                )
                printState()
            }

            is UiEvent.PasswordChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    password = event.password
                )
                printState()

            }

            else -> {}
        }
    }

    private fun printState() {
        Log.d(Tag, "Inside Printstate")
        Log.d(Tag, loginUiState.value.toString())
    }
}