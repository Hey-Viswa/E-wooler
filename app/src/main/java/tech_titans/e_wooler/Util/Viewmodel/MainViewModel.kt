package tech_titans.e_wooler.Util.Viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tech_titans.e_wooler.Presentation.Onboarding.Nvgraph.Screens
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
  private val _splashCondition = mutableStateOf(true)

    var startDestination by mutableStateOf(Screens.OnBoardingScreen.route)
        private set

}