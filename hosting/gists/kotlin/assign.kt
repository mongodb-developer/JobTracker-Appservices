
  realm.write {
                var job = unassignedJobs.first();
                // Get it in this thread.
                val currentJob = findLatest(job)
               
                copyToRealm(currentJob.apply {
                    this.status = Status.ASSIGNED.name              
                })
            }