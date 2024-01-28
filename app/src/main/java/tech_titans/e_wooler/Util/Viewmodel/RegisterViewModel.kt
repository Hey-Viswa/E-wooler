package tech_titans.e_wooler.Util.Viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import tech_titans.e_wooler.Util.Data.RegistrationUiState
import tech_titans.e_wooler.Util.Data.UiEvent
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    private val Tag = RegisterViewModel::class.simpleName
    var registrationUiState = mutableStateOf(RegistrationUiState())

    fun onEvent(event:UiEvent){
        when(event){
            is UiEvent.FirstNameChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }
            is UiEvent.LastNameChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }
            is UiEvent.EmailChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
                printState()
            }
            is UiEvent.PasswordChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
                printState()
            }
        }

    }

    private fun printState() {
        Log.d(Tag, "Inside Printstate")
        Log.d(Tag, registrationUiState.value.toString())
    }
}
