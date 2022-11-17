
import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.annotations.PrimaryKey

class Job : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var status: String? = ""
    var desc: String = ""
    var creationDate: RealmInstant? = null
    var area: String = ""
    var user: String? = ""
}