package tech_titans.e_wooler.Presentation.Onboarding.Common

data class User(
    val userName: String,
    val userAge: String,
    val userOccupation: String
) {
    constructor(): this("", "", "")
}