/* Gets a list of all non completed jobs and any recently completed*/
exports = async function(arg){
    const jobCollection = context.services.get("mongodb-atlas").db("job-db").collection("Job");
    live = await jobCollection.find({status:{$in:["UNASSIGNED","ACCEPTED"]}}).sort({status:-1,date:1}).toArray()
    archive =  await jobCollection.find({status:"DONE"}).limit(10).sort({date:1}).toArray()
    return [...live,...archive]
  
}