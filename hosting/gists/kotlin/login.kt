
//Attach to our Server Application

 private val appService by lazy {
        val appConfiguration =
            AppConfiguration.Builder(appId = "jobtrackerrealmapp-mlapp").log(LogLevel.ALL).build()
        App.create(appConfiguration)
    }

//Authenticate

suspend fun login(email: String, password: String): User {
        return appService.login(Credentials.emailPassword(email, password))
    }


//Open a Realm that auto syncs with the server

private val realm by lazy {
    val user = appService.currentUser!!

    //Restrict what we sync to Unassigned jobs and those assigned to us
    //Sync only what we need not the whole database
    
    val config =
        SyncConfiguration.Builder(user, schemaClass).name("job-db").schemaVersion(1)
            .initialSubscriptions { realm ->
                add(realm.query<UserInfo>("_id = $0",user.id), name = "users", updateExisting = true)
                add(realm.query<Job>("user = $0 OR status = $1", user.email, Status.UNASSIGNED.name),
                 name = "jobs", updateExisting = true)
                add(realm.query<Location>(), name = "location", updateExisting = true)
            }.waitForInitialRemoteData().build()

    Realm.open(config)
}