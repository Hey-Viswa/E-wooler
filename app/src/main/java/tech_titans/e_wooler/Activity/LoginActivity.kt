package tech_titans.e_wooler.Activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech_titans.e_wooler.Presentation.Onboarding.Common.SocialMediaLogin
import tech_titans.e_wooler.Presentation.Onboarding.Component.LoginTextFieldEmail
import tech_titans.e_wooler.Presentation.Onboarding.Component.LoginTextFieldPassword
import tech_titans.e_wooler.R
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@Composable
fun Loginscreen() {
    Surface() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopSection()
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {

                BottomSection()
                Spacer(modifier = Modifier.height(30.dp))
                SocialMediaSection()
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF94a3b8),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("Don't have account?")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        ) {
                            append(" ")
                            append("Create now")
                        }
                    })
                }
            }
        }
    }
}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelSmall.copy(color = Color(0xff64748b))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(),
            verticalAlignment = Alignment.CenterVertically,


            ) {

            SocialMediaLogin(
                icon = R.drawable.google,
                text = "Google  ",
                modifier = Modifier.weight(1f)
            ) {

            }
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogin(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {

            }
        }
    }
}

@Composable
private fun BottomSection() {

    LoginTextFieldEmail(
        label = "Email",
        leadingIcon = Icons.Filled.Email,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(15.dp))
    LoginTextFieldPassword(
        label = "Password",
        leadingIcon = Icons.Filled.Lock,
        trailingIcon = Icons.Filled.VisibilityOff,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
    ElevatedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(size = 10.dp)
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }

}


@Composable
private fun TopSection() {
    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.knitting),
                contentDescription = null,

                )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = "E-wooler",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Farm to Fabric",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(start = 5.dp),
                    fontStyle = FontStyle.Normal

                )
            }
        }
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = "Login",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun LoginActivityPreview() {
    EwoolerTheme {
        Loginscreen()
    }
}