exports = async function({user}){


  console.log("user calling --- " + JSON.stringify({user}));

  //Accessing a mongodb service:
    var collection = context.services.get("mongodb-atlas").db("job-db").collection("UserInfo");
    var count = await collection.count({
      email: user.data.email
    });


    console.log('count ---'+ count)

    if(count == 0){
      const userDoc = {
       _id: user.id,
       email: user.data.email,
       name: "",
       phoneNumber: ""
     }

    collection.insertOne(userDoc)
    .then (result => {
        console.log(` document for _id: ${result}`);
      }, error => {
        console.log(`Failed to write ${error}`);
      });

    }else{
      console.log('This is a duplicate user');
      // Do nothing duplicate user
    }

    return {user}
};