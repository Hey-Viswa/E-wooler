package tech_titans.e_wooler.Activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import tech_titans.e_wooler.Presentation.Onboarding.Common.SocialMediaLogin
import tech_titans.e_wooler.Presentation.Onboarding.Component.AppFont
import tech_titans.e_wooler.Presentation.Onboarding.Component.ButtonComponent
import tech_titans.e_wooler.Presentation.Onboarding.Component.CustomRoundedShape
import tech_titans.e_wooler.Presentation.Onboarding.Component.CustomText
import tech_titans.e_wooler.Presentation.Onboarding.Component.HeadlineTextComponent
import tech_titans.e_wooler.Presentation.Onboarding.Component.MyPasswordTextField
import tech_titans.e_wooler.Presentation.Onboarding.Component.MyTextField
import tech_titans.e_wooler.Presentation.Onboarding.Component.NormalTextComponent
import tech_titans.e_wooler.Presentation.Onboarding.Nvgraph.Screens
import tech_titans.e_wooler.R
import tech_titans.e_wooler.Util.Data.UiEvent
import tech_titans.e_wooler.Util.Viewmodel.RegisterViewModel
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xfff7f8f8)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            CustomRoundedShape(
                backgroundColor = MaterialTheme.colorScheme.primary, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 55.dp)
        ) {
            NormalTextComponent(value = "Hey there,")
            HeadlineTextComponent(value = "Create an Account")
            Spacer(modifier = Modifier.height(55.dp))
            Box(

                modifier = Modifier
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.undraw_undraw_undraw_undraw_undraw_users_per_minute_1e4q_t22j__1__0ngf__1__27dv_30ul),
                    contentDescription = null,

                    )
            }
            Spacer(modifier = Modifier.height(15.dp))
            MyTextField(
                labelValue = "First Name",
                Icons.Outlined.PersonOutline,
                onTextSelected = {
                    registerViewModel.onEvent(UiEvent.FirstNameChanged(it))
                },
                registerViewModel.registrationUiState.value.firstNameError

            )
            MyTextField(
                labelValue = "Last Name",
                Icons.Outlined.PersonOutline,
                onTextSelected = {
                    registerViewModel.onEvent(UiEvent.LastNameChanged(it))
                },
                registerViewModel.registrationUiState.value.lastNameError


            )
            MyTextField(
                labelValue = "Email",
                Icons.Outlined.Email,
                onTextSelected = {
                    registerViewModel.onEvent(UiEvent.EmailChanged(it))
                },
                registerViewModel.registrationUiState.value.emailError

            )
            MyPasswordTextField(
                labelValue = "Password",
                leadingIcon = Icons.Outlined.Password,
                onTextSelected = {
                    registerViewModel.onEvent(UiEvent.PasswordChanged(it))
                },
                registerViewModel.registrationUiState.value.passwordError
            )
            Spacer(modifier = Modifier.height(15.dp))
            ButtonComponent(
                value = "Register",
                onButtonClick = {
                    registerViewModel.onEvent(UiEvent.RegisterbuttonClicked)
                },
                isEnabled = registerViewModel.allValidationPassed.value
                )

            Spacer(modifier = Modifier.height(20.dp))
            CustomText(
                text = "or Continue with",
                color = Color.Black,
                textAlign = TextAlign.Center,
            )


            Spacer(modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    SocialMediaLogin(
                        icon = R.drawable.google_color_svgrepo_com,
                        text = "Google  ",
                        modifier = Modifier.weight(1f)
                    ) {

                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    SocialMediaLogin(
                        icon = R.drawable.facebook_color_svgrepo_com,
                        text = "Facebook",
                        modifier = Modifier.weight(1f)
                    ) {

                    }


                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontSize = 12.sp,
                                    fontFamily = AppFont.Poppins,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("Already have an Account? ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 12.sp,
                                    fontFamily = AppFont.Poppins,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" Login Now")
                            }
                        },
                        modifier = Modifier.clickable {
                            scope.launch {
                                navController.navigate(Screens.LoginScreen.route) {
                                    popUpTo(Screens.LoginScreen.route) {
                                        inclusive = true
                                    }
                                }
                            }

                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController() // You should import rememberNavController
    EwoolerTheme {
        RegisterScreen(navController = navController)
    }
}
