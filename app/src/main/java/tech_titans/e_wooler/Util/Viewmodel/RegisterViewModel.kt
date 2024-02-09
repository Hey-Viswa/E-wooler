package tech_titans.e_wooler.Util.Viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import tech_titans.e_wooler.Util.Constants.TAG
import tech_titans.e_wooler.Util.Data.RegistrationUiState
import tech_titans.e_wooler.Util.Data.Rules.Validator
import tech_titans.e_wooler.Util.Data.UiEvent
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {
    private val Tag = RegisterViewModel::class.simpleName
    var registrationUiState = mutableStateOf(RegistrationUiState())

    var allValidationPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)


    fun onEvent(event: UiEvent) {
        validateDataWithRulesRegister()
        when (event) {
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

            is UiEvent.RegisterbuttonClicked -> {
                signUp()
            }

            else -> {}
        }
        validateDataWithRulesRegister()

    }

    private fun signUp() {
        Log.d(Tag, "Inside signup")
        printState()
        createUserInFirebase(
            email = registrationUiState.value.email,
            password = registrationUiState.value.password
        )
    }

    private fun validateDataWithRulesRegister() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUiState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = registrationUiState.value.lastName
        )
        val email = Validator.validateEmail(
            email = registrationUiState.value.email
        )
        val password = Validator.validatePassword(
            password = registrationUiState.value.password
        )

        Log.d(Tag, "Inside_Validation")
        Log.d(Tag, "fNameRes = $fNameResult")
        Log.d(Tag, "lNameRes = $lNameResult")
        Log.d(Tag, "emailRes = $email")
        Log.d(Tag, "password = $password")

        registrationUiState.value = registrationUiState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = email.status,
            passwordError = password.status
        )

        allValidationPassed.value = fNameResult.status && lNameResult.status &&
                email.status && password.status

    }

    private fun printState() {
        Log.d(Tag, "Inside Print state")
        Log.d(Tag, registrationUiState.value.toString())
    }

    private fun createUserInFirebase(email: String, password: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, " isSuccessful = ${it.isSuccessful}")

                signUpInProgress.value = false
                if (it.isSuccessful) {

                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception= ${it.message}")
                Log.d(TAG, "Exception= ${it.localizedMessage}")
            }
    }
}
