/* Gets a list of all non completed jobs and any recently completed*/
exports = async function(area,desc){
  
    //We can check the context.user explicitly here and only allow those we want
    
    const jobCollection = context.services.get("mongodb-atlas").db("job-db").collection("Job");
    const areaCollection = context.services.get("mongodb-atlas").db("job-db").collection("Location");
    
    const areaDoc = await areaCollection.findOne({name: area});
    if(areaDoc == null) {
      return { ok: false,message: `unknown area ${area}`}
    }
    
    let newJob = {
      area,desc,creationDate: new Date(), status: "UNASSIGNED",user: null
    }
    
    const rval = await jobCollection.insertOne(newJob)
    console.log(rval);
    return rval;
  
}