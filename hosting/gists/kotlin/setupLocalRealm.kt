

private val deviceRealm by lazy {
    val deviceConfig =
        RealmConfiguration.Builder(schemaClass).name("job-db").schemaVersion(1).build()
    Realm.open(deviceConfig)
}
