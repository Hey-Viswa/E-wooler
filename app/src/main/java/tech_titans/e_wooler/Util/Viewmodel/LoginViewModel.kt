package tech_titans.e_wooler.Util.Viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import tech_titans.e_wooler.Util.Constants.TAG
import tech_titans.e_wooler.Util.Data.LoginUiState
import tech_titans.e_wooler.Util.Data.Rules.Validator
import tech_titans.e_wooler.Util.Data.UiEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {
    private val Tag = LoginViewModel::class.simpleName
    var loginUiState = mutableStateOf(LoginUiState())

    var allValidationPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: UiEvent) {
        validateDataWithRulesLogin()
        when (event) {
            is UiEvent.EmailChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    email = event.email
                )

            }

            is UiEvent.PasswordChanged -> {
                loginUiState.value = loginUiState.value.copy(
                    password = event.password
                )


            }
            is UiEvent.LoginbuttonClicked -> {
                signUp()
            }

            else -> {}
        }
    } private fun signUp(){
        Log.d(Tag, "Inside login")
        createUserInFirebase(email = loginUiState.value.email , password = loginUiState.value.password,)
    }
    private fun validateDataWithRulesLogin() {

        val email = Validator.validateEmail(
            email =  loginUiState.value.email
        )
        val password = Validator.validatePassword(
            password =  loginUiState.value.password
        )


        loginUiState.value = loginUiState.value.copy(
            emailError = email.status,
            passwordError = password.status
        )
        allValidationPassed.value = email.status && password.status
    }




     private fun createUserInFirebase(email:String,password:String){

         loginInProgress.value = true
         val email = loginUiState.value.email
         val password = loginUiState.value.password
         val navController = NavController
         FirebaseAuth
             .getInstance()
             .signInWithEmailAndPassword(email, password)
             .addOnCompleteListener {
                 Log.d(TAG,"Inside_login_success")
                 Log.d(TAG,"${it.isSuccessful}")

                 if(it.isSuccessful){
                     loginInProgress.value = false

                 }
             }
             .addOnFailureListener {
                 Log.d(TAG,"Inside_login_failure")
                 Log.d(TAG,"${it.localizedMessage}")

                 loginInProgress.value = false

             }
    }

}