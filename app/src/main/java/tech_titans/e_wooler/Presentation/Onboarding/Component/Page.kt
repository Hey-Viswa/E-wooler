package tech_titans.e_wooler.Presentation.Onboarding.Component

import androidx.annotation.DrawableRes
import tech_titans.e_wooler.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Welcome to Ewooler",
        "Welcome to Ewooler, where the magic of wool comes to life! Immerse yourself in a world of warmth, comfort, and sustainable luxury. Swipe to learn more",
        R.drawable.wool1
    ),
    Page(
        "Premium Wool, Ethical Origins",
        "At Ewooler, we believe in the beauty of nature and the goodness of quality materials.",
        R.drawable.wool2
    ),
    Page(
        "Effortless Elegance, One Swipe Away",
        "Shopping for wool has never been this easy!, Navigate effortlessly through our app, Happy shopping!",
        R.drawable.wool3
    ),
)