import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.Credentials


 private val appService by lazy {
        val appConfiguration =
            AppConfiguration.Builder(appId = "jobtrackerrealmapp-mlapp").log(LogLevel.ALL).build()
        App.create(appConfiguration)
    }
    
suspend fun login(email: String, password: String): User {
        return appService.login(Credentials.emailPassword(email, password))
    }