realm.write {

    val job = Job().apply {
        desc = "Random Job"
        area = "New York"
        creationDate = RealmInstant.now()
        status = Status.UNASSIGNED.name
        this.user = null
    }
    copyToRealm(job)
}