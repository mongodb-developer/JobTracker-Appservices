suspend fun registration(password: String, email: String) {
    appService.emailPasswordAuth.registerUser(email = email, password = password)
}