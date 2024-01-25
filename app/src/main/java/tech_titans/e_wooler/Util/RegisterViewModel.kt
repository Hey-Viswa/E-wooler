package tech_titans.e_wooler.Util
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech_titans.e_wooler.AuthRepository
import tech_titans.e_wooler.Domain.Manager.UseCases.Resource
import tech_titans.e_wooler.Presentation.Onboarding.Component.RegisterState
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository,

    ) : ViewModel() {

    val _registerState = Channel<RegisterState>()
    val registerState = _registerState.receiveAsFlow()


    fun registerUser(email: String, password: String) = viewModelScope.launch {
        repository.registerUser(email, password).collect() { result ->
            when (result) {
                is Resource.Success -> {
                    _registerState.send(RegisterState(isSuccess = "Register Success"))
                }

                is Resource.Loading -> {
                    _registerState.send(RegisterState(isLoading = true))
                }

                is Resource.Error -> {
                    _registerState.send(RegisterState(isError = result.message))
                }
            }

        }
    }


}