
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import tech_titans.e_wooler.Presentation.Onboarding.Component.AppFont
import tech_titans.e_wooler.Presentation.Onboarding.Nvgraph.Screens
import tech_titans.e_wooler.R

@Composable
fun SignupAndLoginScreenLayout(
    navController: NavHostController,

) {
    val scope = rememberCoroutineScope()

   
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xfff7f8f8)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(vertical = 24.dp))
        // Display the headline text
        Text(
            text = "Introducing the Ultimate \n Wool E-Commerce Experience!",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = AppFont.Poppins
        )
        Spacer(modifier = Modifier.padding(vertical = 14.dp))
        // Display the subheading text
        Text(
            text = "Gain Insight into Your Wool \n Purchases, Know Where Your \nFiber Funds Flow!",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontFamily = AppFont.Poppins,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        // Display the image composable for the illustration
        Spacer(modifier = Modifier.padding(vertical = 30.dp))
        Image(painter = painterResource(id = R.drawable.undraw_undraw_shopping_bags_2ude__1__mnw3), contentDescription = null)
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
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
                    scope.launch {
                        navController.navigate(Screens.RegisterScreen.route)
                    }
                },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 5.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color(0xffe9f2f7)
                ),
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                    fontFamily = AppFont.Poppins,
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 40.dp, end = 40.dp),
                onClick = {
                    scope.launch {
                        navController.navigate(Screens.LoginScreen.route)
                    }
                },
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
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
    // Create a NavController instance
    val navController = rememberNavController()

    // Create a launcher using rememberLauncher


    // Call your composable function with the NavController and the launcher
    SignupAndLoginScreenLayout(navController = navController, )
}