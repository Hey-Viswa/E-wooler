package tech_titans.e_wooler.Activity

// Import the required libraries
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech_titans.e_wooler.R

// Define a composable function to display the layout
@Composable
fun PasswordRecoveryLayout() {
    // Use a Box to center the content
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Use a Column to arrange the content vertically
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the header text
            Text(
                text = "Forgot password",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            // Add some vertical space
            Spacer(modifier = Modifier.height(16.dp))
            // Display the reassuring message
            Text(
                text = "Don’t worry! We got you covered. Please enter select password recovery methods below",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            // Add some vertical space
            Spacer(modifier = Modifier.height(32.dp))
            // Display the password recovery options
            PasswordRecoveryOption(
                icon = Icons.Default.Search,
                text = "+1 937856 7878"
            )
            PasswordRecoveryOption(
                icon = Icons.Default.Search,
                text = "john123@gmail.com"
            )
            // Add some vertical space
            Spacer(modifier = Modifier.height(32.dp))
            // Display the continue button
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Continue")
            }
        }
    }
}

// Define a composable function to display a password recovery option
@Composable
fun PasswordRecoveryOption(icon: ImageVector, text: String) {
    // Use a Row to arrange the icon and text horizontally
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display the icon
        Icon(
            painter = painterResource(id = R.drawable.ewooler_app_logo),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Red
        )
        // Add some horizontal space
        Spacer(modifier = Modifier.width(16.dp))
        // Display the text
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}
