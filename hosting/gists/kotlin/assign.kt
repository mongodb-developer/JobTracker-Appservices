
  realm.write {
                var job = unassignedJobs.first(); //Or whichever job we want to change
                // Open it in this thread - it may be mid txn in another
                findLatest(job).status = Status.ASSIGNED.name              
            }