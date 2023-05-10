package com.graymandev.sapp.model

data class UserSignUp(
    val name: String,
    val surname: String,
    val nickname: String,
    val age: String,
    val orientation: String,
    val email: String,
    val mobile: String,
    val password: String,
    val passwordConfirmation: String
) {
    fun isNotEmpty() =
        name.isNotEmpty() && surname.isNotEmpty() && nickname.isNotEmpty() && age.isNotEmpty() && orientation.isNotEmpty() && email.isNotEmpty() && mobile.isNotEmpty() && password.isNotEmpty() && passwordConfirmation.isNotEmpty()
}