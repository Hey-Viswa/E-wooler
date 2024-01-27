package tech_titans.e_wooler.Presentation.Onboarding.Component

// Import the required libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Colors
import tech_titans.e_wooler.ui.theme.EwoolerTheme

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontFamily = AppFont.Poppins,
        color = MaterialTheme.colorScheme.onPrimary,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadlineTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Normal,
        fontFamily = AppFont.Poppins,
        color = Color(0xffe9f2f7),
        textAlign = TextAlign.Center
    )
}


@Composable
fun CustomRoundedShape(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    cornerRadius: Float = 25f // Default corner radius
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = cornerRadius.dp,
                    bottomEnd = cornerRadius.dp
                )
            )
    ) {
        // You can add content here if needed
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector?,
    onTrailingIconClick: () -> Unit = {}
) {
    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        label = { Text(text = labelValue) },
        shape = RoundedCornerShape(12.dp),

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            cursorColor = MaterialTheme.colorScheme.primary,
            containerColor = Color(0xfff7f8f8),
            focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = null) },
        trailingIcon = {
            trailingIcon?.let {
                IconButton(onClick = onTrailingIconClick) {
                    Icon(imageVector = it, contentDescription = null)
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        }
    )
}


@Composable
fun CustomClickableText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign

    ) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable { onClick() },
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.primary,
        textAlign = textAlign,
        // Added TextStyle here to specify text color
    )
}
@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign,
    color: Color
    ) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 20.dp),
        style = MaterialTheme.typography.bodySmall,
        color = color,
        textAlign = textAlign,
        // Added TextStyle here to specify text color
    )
}
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(4.dp), // Adjust the corner radius as needed
        colors = ButtonDefaults.buttonColors(
            contentColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun ComponentPreview() {
    EwoolerTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            BasicText(text = "Forgot?")
        }
    }
}