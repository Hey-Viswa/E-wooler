package tech_titans.e_wooler.Activity

// Import the required libraries

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech_titans.e_wooler.Presentation.Onboarding.Component.AppFont
import tech_titans.e_wooler.R

// Define a composable function to display the layout

@Composable
fun SignupAndLoginScreenLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffe9f2f7)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(vertical = 24.dp))
        // Display the headline text
        Text(
            text = "Keep your budget\n on track with smart \n" +
                    "analytics",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = AppFont.Poppins
        )
        Spacer(modifier = Modifier.padding(vertical = 14.dp))
        // Display the subheading text
        Text(
            text = "Get a clear view of your spendings,\n know exactly where your money is going",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontFamily = AppFont.Poppins,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        // Display the image composable for the illustration
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        Image(painter = painterResource(id = R.drawable.undraw_undraw_shopping_bags_2ude__1__mnw3), contentDescription = null)
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        // Display the row composable for the buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 40.dp, end = 40.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontFamily = AppFont.Poppins

                )


            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 40.dp, end = 40.dp),
                onClick = {

                },
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = MaterialTheme.colorScheme.primary,
                    fontFamily = AppFont.Poppins

                )


            }
        }
    }
}


@Preview
@Composable
fun pre() {
    SignupAndLoginScreenLayout()
}