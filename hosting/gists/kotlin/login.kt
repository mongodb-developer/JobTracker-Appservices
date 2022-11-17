suspend fun login(email: String, password: String): User {
        return appService.login(Credentials.emailPassword(email, password))
    }