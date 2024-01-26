package tech_titans.e_wooler.Presentation.Onboarding.Component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import tech_titans.e_wooler.R

@Composable
fun ComposableLottieAnimation(){


    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.helo))

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    // Here we have iteration parameter we can use for auto loop
    LottieAnimation(composition = composition, progress = { progress })

}


@Preview
@Composable
fun pr(){
    ComposableLottieAnimation()
}