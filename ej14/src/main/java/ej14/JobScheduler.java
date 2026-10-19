package ej14;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    private List<JobDescription> jobs;
    private Policy policy;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
        this.policy = new FIFOPolicy();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public Policy getPolicy() {
        return this.policy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public JobDescription next() {
        if (jobs.isEmpty()){
            return null;
        }
        JobDescription nextJob = this.policy.selectNext(jobs);
        this.unschedule(nextJob);
        return nextJob;
    }
}
