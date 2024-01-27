import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech_titans.e_wooler.Presentation.Onboarding.Component.CustomClickableText
import tech_titans.e_wooler.Presentation.Onboarding.Component.CustomRoundedShape
import tech_titans.e_wooler.Presentation.Onboarding.Component.HeadlineTextComponent
import tech_titans.e_wooler.Presentation.Onboarding.Component.MyTextField
import tech_titans.e_wooler.Presentation.Onboarding.Component.NormalTextComponent
import tech_titans.e_wooler.R
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@Composable
fun RegisterScreen() {
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
                    .width(260.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.undraw_sign_up_n6im),
                    contentDescription = null,

                    )
            }
            Spacer(modifier = Modifier.height(15.dp))
            MyTextField(
                labelValue = "First Name",
                Icons.Outlined.PersonOutline,
                null
            )
            MyTextField(
                labelValue = "Last Name",
                Icons.Outlined.PersonOutline,
                null
            )
            MyTextField(
                labelValue = "Email",
                Icons.Outlined.Email,
                null
            )
            MyTextField(
                labelValue = "Password",
                Icons.Outlined.Password,
                trailingIcon = Icons.Outlined.VisibilityOff,
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomClickableText(text = "forgot?", onClick = { /*TODO*/ }, textAlign = TextAlign.End)
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    EwoolerTheme {
        RegisterScreen()
    }
}
