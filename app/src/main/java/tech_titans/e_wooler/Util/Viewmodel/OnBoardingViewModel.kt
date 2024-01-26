package tech_titans.e_wooler.Util.Viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech_titans.e_wooler.Domain.Manager.UseCases.AppEntryUseCase
import tech_titans.e_wooler.Presentation.Onboarding.OnBoardingEvent
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase
) : ViewModel() {

    private val sharedPreferences : SharedPreferences = TODO()
    fun checkOnboardingStatus(): Boolean {
        return sharedPreferences.getBoolean("onboarding_completed", false)
    }

    fun setOnboardingComplete() {
        sharedPreferences.edit().putBoolean("onboarding_completed", true).apply()
    }

    private val _onBoardingEventChannel = Channel<OnBoardingEvent>()
    val onBoardingEventFlow = _onBoardingEventChannel.receiveAsFlow()
    fun onEvent(event: OnBoardingEvent) {
        viewModelScope.launch {
            _onBoardingEventChannel.send(event)
            saveAppEntry()
        }
    }

    fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }

}