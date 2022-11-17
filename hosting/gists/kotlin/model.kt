
//a Job class, we index by status and area too

class Job : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    @Index
    var status: String? = ""
    var desc: String = ""
    var creationDate: RealmInstant? = null
    @Index
    var area: String = ""
    var user: String? = ""
}


// Open a Realm - not network connected

private val realm by lazy {
    val deviceConfig =
        RealmConfiguration.Builder(schemaClass).name("job-db").schemaVersion(1).build()
    Realm.open(deviceConfig)
}


// Fetch lists  objects meeting a criteria with Query

var unassignedJobs  = realm.query<Job>("status = $0 AND area = $1", Status.UNASSIGNED.name,location.name)
var acceptedJobs = realm.query<Job>("status = $0", Status.ACCEPTED.name)
var completedJobs = realm.query<Job>("status = $0", Status.DONE.name)

