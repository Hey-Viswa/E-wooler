package tech_titans.e_wooler.Presentation.Onboarding.Common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech_titans.e_wooler.Presentation.Onboarding.Component.OnBoardingPage
import tech_titans.e_wooler.Presentation.Onboarding.pages
import tech_titans.e_wooler.ui.theme.EwoolerTheme


@Composable
fun WoolButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 10.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
                )
    }
}

@Preview
@Composable
fun WoolButtonPreview() {
    EwoolerTheme {
           WoolButton(
               text = "Hello",
               onClick = {}
           )
    }
}