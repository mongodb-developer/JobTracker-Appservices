// Run this in Mongosh


db = db.getSiblingDB('job-db')
jobs = db.Job

item = ["Passenger","cat","dog","doctor","nurse","parcel","package","takeaway","pizza"]
adjective = ["old","new","North","South","East","West","abandoned"]
place = ["school","church","dock","harbour","station","airport","department store"]
users = ['alice','bob','eve','john','paul','george','ringo']
areas =  ['Houston','Chicago','New York','Philidelphia','Miami','Los Angeles','Dallas']
tasks = []
tasks.push ( (item,adv1,place1,adv2,place2) => `Pick up a ${item} from the ${adv1} ${place1} and take to the ${adv2} ${place2}`);
tasks.push ( (item,adv1,place1,adv2,place2) => `Go to ${adv1} ${place1} get a ${item} and take to the ${adv2} ${place2}`);
tasks.push ( (item,adv1,place1,adv2,place2) => `Collect a ${item} from the ${adv1} ${place1} and take to the ${adv2} ${place2}`);
tasks.push ( (item,adv1,place1,adv2,place2) => `Go to  ${adv1} ${place1} and await further instructions`);
tasks.push ( (item,adv1,place1,adv2,place2) => `Look for a ${item} near  ${adv1} ${place1} and grab it.`);
tasks.push ( (item,adv1,place1,adv2,place2) => `At the ${adv1} ${place1} is a ${item} that needs to go to ${adv2} ${place2}.`);


function choose(l) {
    return l[Math.floor(Math.random()*l.length)]
}
nRecs = 10000;
for(x=0;x<nRecs;x++) {
    _id = new ObjectId();
    task = choose(tasks)
    desc = choose(tasks)(choose(item),choose(adjective),choose(place),choose(adjective),choose(place))
    area = choose(areas);
    status = 'DONE';
    user = choose(users);
    creationDate = new Date();
   jobs.insertOne({id,area,desc,status,user,creationDate,user});

}