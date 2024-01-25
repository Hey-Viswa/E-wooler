package tech_titans.e_wooler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech_titans.e_wooler.Domain.Manager.UseCases.Resource
import tech_titans.e_wooler.Presentation.Onboarding.Component.LoginState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: AuthRepository,

    ) : ViewModel() {

    val _LoginState = Channel<LoginState>()
    val LoginState = _LoginState.receiveAsFlow()


    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect() { result ->
            when (result) {
                is Resource.Success -> {
                    _LoginState.send(LoginState(isSuccess = "Login Success"))
                }

                is Resource.Loading -> {
                    _LoginState.send(LoginState(isLoading = true))
                }

                is Resource.Error -> {
                    _LoginState.send(LoginState(isError = result.message))
                }
            }

        }
    }


}