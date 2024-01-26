package tech_titans.e_wooler.Presentation.Onboarding.Common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import tech_titans.e_wooler.R

@Composable
fun LoginTextFieldEmail(
    modifier: Modifier = Modifier,
    label: String,
    leadingIcon: ImageVector,
) {

    var emailAddress by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        modifier = modifier,
        value = emailAddress,
        onValueChange = {emailAddress = it},
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
        },

        maxLines = 1,
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.primary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        leadingIcon = {

            Icon(
                imageVector = leadingIcon,
                contentDescription = null, // Provide a content description if needed
                tint = MaterialTheme.colorScheme.onPrimaryContainer // Set the tint color
            )

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),


        )
}


@Composable
fun LoginTextFieldPassword(
    modifier: Modifier = Modifier,
    label: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector, // Use ImageVector for the trailing icon
) {

    var password by remember { mutableStateOf(TextFieldValue("")) }
    val passwordVisible = remember {
        mutableStateOf(false)
    }



    TextField(
        modifier = modifier,
        value = password,
        onValueChange = { password = it},
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.primary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null, // Provide a content description if needed
                    tint = MaterialTheme.colorScheme.onPrimaryContainer // Set the tint color
                )
            }
        },
        trailingIcon = {

                val iconImage = if (passwordVisible.value){
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }

                var description = if (passwordVisible.value){
                    "Hide Password"
                }else{
                    "Show Password"
                }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


        )
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

