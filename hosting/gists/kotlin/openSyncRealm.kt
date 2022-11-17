private val realm by lazy {
    val user = appService.currentUser!!

    val config =
        SyncConfiguration.Builder(user, schemaClass).name("job-db").schemaVersion(1)
            .initialSubscriptions { realm ->
                add(realm.query<UserInfo>(), name = "users", updateExisting = true)
                add(realm.query<Job>(), name = "jobs", updateExisting = true)
                add(realm.query<Location>(), name = "location", updateExisting = true)
            }.waitForInitialRemoteData().build()
    Realm.open(config)
}
