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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import tech_titans.e_wooler.Presentation.Onboarding.Component.LoginTextField
import tech_titans.e_wooler.R

@Composable
fun Loginscreen() {
    Surface() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
            }
        }
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
                .fillMaxHeight(0.46f),
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
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
    }
}